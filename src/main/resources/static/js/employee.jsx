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

class AddEmployee extends React.Component {

  constructor() {
    super();
    this.onComplete = this.handleOnComplete.bind(this);
  }

  handleOnComplete() {
    if($(".addEmployeeButton").hasClass("btn-success") || $(".clearAddEmployeeButton").click() ){
      $("input[name='name']").val("");
      $("input[name='surname']").val("");
      $("input[name='salary']").val("");

      $(".addEmployeePanel")
        .removeClass("panel-success")
        .addClass("panel-primary");

      $(".addEmployeePanel > .panel-heading").text("Add Employee"); 

      $(".addEmployeeButton")
        .removeClass("btn-success")
        .addClass("btn-primary")
        .text("Add");
    }

  }


  render(){
    return(
    <Col lg={6}>
      <Panel bsStyle="primary" header="Add Employee" className="addEmployeePanel">
      <Form horizontal name="addEmployeeForm" method="POST" action="employee/add">
        <FormGroup>
          <Col componentClass={ControlLabel} sm={2}>
            Name
          </Col>
          <Col sm={10}>
            <FormControl type="input" placeholder="Name" name="name" />
          </Col>
        </FormGroup>
    
        <FormGroup>
          <Col componentClass={ControlLabel} sm={2}>
            Surname
          </Col>
          <Col sm={10}>
            <FormControl type="input" placeholder="Surname" name="surname" />
          </Col>
        </FormGroup>

         <FormGroup>
          <Col componentClass={ControlLabel} sm={2}>
            Salary
          </Col>
          <Col sm={10}>
            <FormControl type="input" placeholder="Salary" name="salary" />
          </Col>
        </FormGroup>
            <FormControl type="hidden" name="id" />
        <FormGroup>
          <Col smOffset={2} lg={2}>
            <Button bsStyle="primary" type="submit" className="addEmployeeButton" onComplete={() => this.handleOnComplete()}>
              Add
            </Button>
          </Col>

          <Col lg={2}>
            <Button bsStyle="warning" type="button" className="clearAddEmployeeButton" onClick={() => this.handleOnComplete()}>
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


class EmployeeRow extends React.Component {

  constructor() {
    super();
    this.onClick = this.handleClick.bind(this);
  }

  
  handleClick(id,name,surname,salary) {
    $("input[name='id']").val(id);
    $("input[name='name']").val(name);
    $("input[name='surname']").val(surname);
    $("input[name='salary']").val(salary);

    $(".addEmployeePanel")
      .removeClass("panel-primary")
      .addClass("panel-success");

    $(".addEmployeePanel > .panel-heading").text("Edit Employee");      
    $(".addEmployeeButton")
      .removeClass("btn-primary")
      .addClass("btn-success")
      .text("Update");

    $("form[name='addEmployeeForm']").attr("action","employee/update");

  }


  render() {
    var id = this.props.employee.id;
    var name = this.props.employee.name;
    var surname = this.props.employee.surname;
    var salary = this.props.employee.salary;
    var deleteHref = "employee/delete/" + id;

      return (
        <tr>
          <td>{name}</td>
          <td>{surname}</td>
          <td>{salary}</td>
          <td>
            <Button bsStyle="danger" href={deleteHref} >Delete</Button>
          </td>
          <td>
            <Button bsStyle="success" onClick={() => this.onClick(id,name,surname,salary)} >Update</Button>
          </td>
        </tr>
      );
  }
}

class EmployeeTable extends React.Component {
  render() {
    var rows = [];
    this.props.employees.forEach(function(employee) {
      rows.push(<EmployeeRow employee={employee} key={employee.name} />);
    });
      return (
          <Grid className="employeeTable">
            <AddEmployee />
            <Col lg={6}>
              <Panel header="Employees">
                  <form name="employeeTableForm">
                    <table className="table">
                      <thead>
                        <tr>
                          <th>Name</th>
                          <th>Surname</th>
                          <th>Salary</th>
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

var applicationUrl = $(location).attr("protocol") + "//"+ $(location).attr("host") + $(location).attr("pathname");  

$.getJSON( applicationUrl + "/employees", function( data ) {
    ReactDOM.render(<EmployeeTable employees={data} />,document.getElementById('root'));
 });


