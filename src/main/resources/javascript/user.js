var port = "8080";
var passwordCorrect = false;

function User(username, email, password){
	this.username = username;
	this.email = email;
	this.password = password;
}

function submitForm(){
	alert("hola");
}


$(document).ready(function(){

	$('#loading-image').hide();
	$('#contenedor-login').hide();
	$('#contenedor-register').hide();

	
	$("#volver-button").on("click", function(){
		window.location.href = "index.html";
	});


	$(document).ready(function(){
		$("#entrar-button").on("click", function(){
			$('#contenedor-register').hide();
			$('#contenedor-login').show();
			$("#submit-login-form-button").on("click", function(){
				submitForm();
			});
		});

		$("#registrarse-button").on("click", function(){
			$('#contenedor-login').hide();
			$('#contenedor-register').show();
			$("#submit-register-form-button").prop("disabled", true);
			$("#register-password-repeat").on('keyup', function(){
				passwordCorrect = $("#register-password-repeat").val() == $("#register-password").val();
				if(passwordCorrect){
					$('#message').html('Las contraseñas coinciden').css('color', 'green');
				} else {
					$('#message').html('Las contraseñas no coinciden').css('color', 'red');
				}
				$("#submit-register-form-button").prop("disabled", !passwordCorrect);
			})
			$("#submit-register-form-button").on("click", function(){
				submitForm();
			});
		});
	});

	
});