var Nav = ReactBootstrap.Nav;
var Navbar = ReactBootstrap.Navbar;
var NavItem = ReactBootstrap.NavItem;
var NavDropdown = ReactBootstrap.NavDropdown;
var MenuItem = ReactBootstrap.MenuItem;
var Link = ReactBootstrap.Link;

var applicationHost = "/" + $(location).attr("pathname").split("/")[1];

const navbarInstance = (
  <Navbar inverse collapseOnSelect fixedTop>
    <Navbar.Header>
      <Navbar.Brand>
        <a  href={applicationHost} >Mebitech Todo App</a>
      </Navbar.Brand>
      <Navbar.Toggle />
    </Navbar.Header>
    <Navbar.Collapse>
     <Navbar.Text>
        <Navbar.Link href="employee">Employee</Navbar.Link>
     </Navbar.Text>
     <Navbar.Text>
        <Navbar.Link href="department">Department</Navbar.Link>
     </Navbar.Text>
     <Navbar.Text>
        <Navbar.Link href="meeting">Meeting</Navbar.Link>
     </Navbar.Text>
    </Navbar.Collapse>
  </Navbar>
);

var mountNode = document.getElementById("navbar");

ReactDOM.render(navbarInstance,mountNode);
