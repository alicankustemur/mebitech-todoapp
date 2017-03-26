var Form = ReactBootstrap.Form;
var FormGroup = ReactBootstrap.FormGroup;
var FormControl = ReactBootstrap.FormControl;
var Col = ReactBootstrap.Col;
var Checkbox = ReactBootstrap.Checkbox;
var ControlLabel = ReactBootstrap.ControlLabel;
var Button = ReactBootstrap.Button;
var Grid = ReactBootstrap.Grid;
var Row = ReactBootstrap.Row;
var Panel = ReactBootstrap.Panel;
var DropdownButton = ReactBootstrap.DropdownButton;

class AddMeeting extends React.Component {

  constructor() {
    super();
    this.onComplete = this.addMeetingOnComplete.bind(this);
  }

  addMeetingOnComplete() {
    if($(".addMeetingButton").hasClass("btn-success") || $(".clearMeetingButton").click() ){
      $("input[name='name']").val("");
      $("textarea[name='description']").val("");

      $(".addMeetingPanel")
        .removeClass("panel-success")
        .addClass("panel-primary");

      $(".addMeetingPanel > .panel-heading").text("Add Meeting"); 

      $(".addMeetingButton")
        .removeClass("btn-success")
        .addClass("btn-primary")
        .text("Add");

      $("select[name='department'] option").prop("selected",false);

    }

  }

  render(){
    var departments = [];
    var index = 0;
    this.props.departments.forEach(function(department) {
      if(index == 1){
        departments.push(<option key={index++} value={department.id} active >{department.name}</option>); 
      }else{
        departments.push(<option key={index++} value={department.id}>{department.name}</option>);   
      }
      
    });
    return(
    <Col lg={6}>
      <Panel bsStyle="primary" header="Add Meeting" className="addMeetingPanel">
      <Form horizontal name="addMeetingForm" method="POST" action="meeting/add">
        <FormGroup>
          <Col componentClass={ControlLabel} sm={2}>
            Name
          </Col>
          <Col sm={10}>
            <FormControl type="input" placeholder="Name" name="name" required />
          </Col>
        </FormGroup>
    
        <FormGroup>
          <Col componentClass={ControlLabel} sm={2}>
            Description
          </Col>
          <Col sm={10}>
            <FormControl componentClass="textarea" rows="4" placeholder="Description" name="description" required/>
          </Col>
        </FormGroup>
        <FormGroup>
          <Col componentClass={ControlLabel} sm={2}>
            Employee
          </Col>
          <Col sm={10}>
            <select className="form-control departmentsDropDown" name="department" required>
              {departments}
            </select>
          </Col>
        </FormGroup>
            <FormControl type="hidden" name="id" />
        <FormGroup>
          <Col smOffset={2} lg={2}>
            <Button bsStyle="primary" type="submit" className="addMeetingButton" onComplete={() => this.addMeetingOnComplete()}>
              Add
            </Button>
          </Col>

          <Col lg={2}>
            <Button bsStyle="warning" type="button" className="clearMeetingButton" onClick={() => this.addMeetingOnComplete()}>
                Clear
            </Button>
          </Col>
        </FormGroup>
      </Form>
    </Panel>
  </Col>
    );
  }
}


class MeetingRow extends React.Component {

  constructor() {
    super();
    this.onClick = this.handleClick.bind(this);
  }

  
  handleClick(id,name,description,departmentId) {
    $("input[name='id']").val(id);
    $("input[name='name']").val(name);
    $("textarea[name='description']").val(description);
    $("select[name='department'] > option[value='"+ departmentId +"']").prop("selected",true);

    $(".addMeetingPanel")
      .removeClass("panel-primary")
      .addClass("panel-success");

    $(".addMeetingPanel > .panel-heading").text("Edit Department");      
    $(".addMeetingButton")
      .removeClass("btn-primary")
      .addClass("btn-success")
      .text("Update");

    $("form[name='addMeetingForm']").attr("action","meeting/update");

  }

  render() {
    var id = this.props.meeting.id;
    var name = this.props.meeting.name;
    var description = this.props.meeting.description;
    var department = this.props.meeting.department;
    var departmentId = this.props.meeting.department.id;
    var deleteHref = "meeting/delete/" + id;

      return (
        <tr>
          <td>{name}</td>
          <td>{description}</td>
          <td className="department" id={departmentId} >{department.name}</td>
          <td>
            <Button bsStyle="danger" href={deleteHref} >Delete</Button>
          </td>
          <td>
            <Button bsStyle="success" onClick={() => this.onClick(id,name,description,departmentId)} >Update</Button>
          </td>
        </tr>
      );
  }
}

class MeetingTable extends React.Component {
  render() {
    var rows = [];
    this.props.meetings.forEach(function(meeting) {
      rows.push(<MeetingRow meeting={meeting} key={meeting.name} />);
    });

    var departments = this.props.departments;
      return (
          <Grid className="meetingTable">
            <AddMeeting departments={departments} />
            <Col lg={6}>
              <Panel header="Meetings">
                  <form name="meetingTableForm">
                    <table className="table">
                      <thead>
                        <tr>
                          <th>Name</th>
                          <th>Description</th>
                          <th>Departments</th>
                        </tr>
                      </thead>
                      <tbody>{rows}</tbody>
                    </table>
                  </form>
                </Panel>
              </Col>
          </Grid>
      );
  }
}

var applicationUrl = $(location).attr("protocol") + "//"+ $(location).attr("host") + "/" + $(location).attr("pathname").split("/")[1];

$.getJSON( applicationUrl + "/meeting/meetings", function( meetings ) {
    $.getJSON( applicationUrl + "/department/departments", function( departments ) {

    ReactDOM.render(<MeetingTable meetings={meetings} departments={departments}/>,document.getElementById('root'));
     });
 });


