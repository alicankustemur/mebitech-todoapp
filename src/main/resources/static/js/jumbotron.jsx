class Jumbotron extends React.Component {
  render() {
  	return(
  		<div className="jumbotron">
	      <div className="container">
	        <h1>Todo App</h1>
	        <p> This is a simple <b>Spring Boot</b> and <b>React</b> project.</p>
			 <p>The goal of the project ; save employees, departments and meeting information to using basic database operations. </p>
	        <p><a className="btn btn-primary btn-lg" target="_blank" href="http://alicankustemur.github.io" role="button">go to my blog. »</a></p>
	      </div>
	    </div>
  	);
  }
}

var mountNode = document.getElementById("jumbotron");

ReactDOM.render(<Jumbotron />,mountNode);