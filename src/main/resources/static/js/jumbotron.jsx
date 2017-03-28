class Jumbotron extends React.Component {
  render() {
  	return(
  		<div className="jumbotron">
	      <div className="container">
	        <h1>Hello, world!</h1>
	        <p>This is a simple Todo application.Create employees, departments and meetings.Your created employees assign to one department and this departments assign to any meetings. </p>
	        <p><a className="btn btn-primary btn-lg" target="_blank" href="http://alicankustemur.github.io" role="button">go to my blog. »</a></p>
	      </div>
	    </div>
  	);
  }
}

var mountNode = document.getElementById("jumbotron");

ReactDOM.render(<Jumbotron />,mountNode);