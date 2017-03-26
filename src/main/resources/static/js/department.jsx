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

class AddDepartment extends React.Component {

  constructor() {
    super();
    this.onComplete = this.addDepartmentOnComplete.bind(this);
  }

  addDepartmentOnComplete() {
    if($(".addDepartmentButton").hasClass("btn-success") || $(".cleDepartmentButton").click() ){
      $("input[name='name']").val("");
      $("textarea[name='description']").val("");

      $(".addDepartmentPanel")
        .removeClass("panel-success")
        .addClass("panel-primary");

      $(".addDepartmentPanel > .panel-heading").text("Add Department"); 

      $(".addDepartmentButton")
        .removeClass("btn-success")
        .addClass("btn-primary")
        .text("Add");

      $("select[name='employee'] option").prop("selected",false);

    }

  }

  render(){
    var employees = [];
    var index = 0;
    this.props.employees.forEach(function(employee) {
      if(index == 1){
        employees.push(<option key={index++} value={employee.id} active >{employee.name}</option>); 
      }else{
        employees.push(<option key={index++} value={employee.id}>{employee.name}</option>);   
      }
      
    });
    return(
    <Col lg={6}>
      <Panel bsStyle="primary" header="Add Department" className="addDepartmentPanel">
      <Form horizontal name="addDepartmentForm" method="POST" action="department/add">
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
            <select className="form-control employeesDropDown" name="employee" required>
              {employees}
            </select>
          </Col>
        </FormGroup>
            <FormControl type="hidden" name="id" />
        <FormGroup>
          <Col smOffset={2} lg={2}>
            <Button bsStyle="primary" type="submit" className="addDepartmentButton" onComplete={() => this.addDepartmentOnComplete()}>
              Add
            </Button>
          </Col>

          <Col lg={2}>
            <Button bsStyle="warning" type="button" className="cleDepartmentButton" onClick={() => this.addDepartmentOnComplete()}>
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


class DepartmentRow extends React.Component {

  constructor() {
    super();
    this.onClick = this.handleClick.bind(this);
  }

  
  handleClick(id,name,description,employeeId) {
    $("input[name='id']").val(id);
    $("input[name='name']").val(name);
    $("textarea[name='description']").val(description);
    $("select[name='employee'] > option[value='"+ employeeId +"']").prop("selected",true);

    $(".addDepartmentPanel")
      .removeClass("panel-primary")
      .addClass("panel-success");

    $(".addDepartmentPanel > .panel-heading").text("Edit Department");      
    $(".addDepartmentButton")
      .removeClass("btn-primary")
      .addClass("btn-success")
      .text("Update");

    $("form[name='addDepartmentForm']").attr("action","department/update");

  }

  render() {
    var id = this.props.department.id;
    var name = this.props.department.name;
    var description = this.props.department.description;
    var employee = this.props.department.employee;
    var employeeId = this.props.department.employee.id;
    var deleteHref = "department/delete/" + id;

      return (
        <tr>
          <td>{name}</td>
          <td>{description}</td>
          <td className="employee" id={employeeId} >{employee.name}</td>
          <td>
            <Button bsStyle="danger" href={deleteHref} >Delete</Button>
          </td>
          <td>
            <Button bsStyle="success" onClick={() => this.onClick(id,name,description,employeeId)} >Update</Button>
          </td>
        </tr>
      );
  }
}

class DepartmentTable extends React.Component {
  render() {
    var rows = [];
    this.props.departments.forEach(function(department) {
      rows.push(<DepartmentRow department={department} key={department.name} />);
    });

    var employees = this.props.employees;
      return (
          <Grid className="departmentTable">
            <AddDepartment employees={employees} />
            <Col lg={6}>
              <Panel header="Departments">
                  <form name="departmentTableForm">
                    <table className="table">
                      <thead>
                        <tr>
                          <th>Name</th>
                          <th>Description</th>
                          <th>Employee</th>
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

$.getJSON( applicationUrl + "/department/departments", function( departments ) {
    $.getJSON( applicationUrl + "/employee/employees", function( employees ) {

    ReactDOM.render(<DepartmentTable departments={departments} employees={employees}/>,document.getElementById('root'));
     });
 });


