var Alert = ReactBootstrap.Alert;

const alertInstance = (
	<Alert alertInstance="success">
		<strong>Hello World!</strong>
	</Alert>
);


var mountNode = document.getElementById("root");

ReactDOM.render(alertInstance,mountNode);
