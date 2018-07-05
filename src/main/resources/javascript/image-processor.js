var port = "8080";
var setting;

var getCardsBySetting = function(setting) {
	$('#loading-image').show();
	setTimeout(function(){
		$.ajax({
			type : 'GET',
			dataType : "json",
			url : "http://localhost:" + port + "/get_images?setting=" + setting,
			success : function(msg) {
				var imagenes = "";
				for(image in msg){
					imagenes += "<div class=\"col-md-2 col-sm-4 col-xs-6 unstable-box\"><img id=\"" + msg[image]['name'] + 
					"\" class=\"imagenes rounded img-responsive img-center\" src=\"" + msg[image]['url'] + "\"></div>";
				}

				$("#contenedor-imagenes").html(imagenes);
				$(".imagenes").on("click", selectImage);
			},
			error : function(msg) {
				$("#contenedor-imagenes").html("<div>error: " + msg + "</div>");
			},
			complete : function(){
				$('#loading-image').hide();
			}
		});
	}, 1200);
		
}

var imagesSelected = 0;

function selectImage() {
	var jQueryElement = $(this);
	console.log('Image clicked: ' + jQueryElement.attr('id').replace('_',' '));
	if(jQueryElement.hasClass('selected')){
		jQueryElement.removeClass('selected');
		imagesSelected--;
	} else {
		jQueryElement.addClass('selected');
		imagesSelected++;
	}
	//Force same height for divs
	var maxHeight = 0;
	$('.unstable-box').each(function () {
	    if ($(this).height() > maxHeight) 
	        maxHeight = $(this).height();
	});
	$('.unstable-box').height(maxHeight);
	$('#submit-form-button').prop('disabled', imagesSelected == 0);
};

function sendCardsToBackEnd(){
	var names = "cards-names=";
	$(".imagenes").each(function(){
		if($(this).hasClass("selected")){
			names += $(this).attr("id") + "-";
		}
	});
	names = names.slice(0, -1);
	var destino = "http://localhost:" + port + "/calculate_final_area?" + names + "&setting=" + setting;
	console.log(destino);
	setTimeout(function(){
		$.ajax({
			type : 'GET',
			dataType : "json",
			url : destino,
			success : function(msg) {
				$("#enviar-button").hide();
				$("#contenedor-imagenes").html("");
				var final = "La zona donde se ha cometido el delito es: " + msg[0]["city"]["name"];
				if(msg[0]["areaValue"] === msg[1]["areaValue"]){
					final += " y la carta con el valor más alto es " + msg[0]["cardWithMaxValue"]["name"].replace("_","");
				}
				$("#contenedor-imagenes").append("<h2 class='respuesta'>" + final + "</h2>");

				for(object in msg){
					var mensaje = "La ciudad " + msg[object]["city"]["name"] + " tiene valor " + msg[object]["areaValue"];
					$("#contenedor-imagenes").append("<h3 class='respuesta'>" + mensaje + "</h3>");
				}
			},
			error : function(msg) {
				$("#contenedor-imagenes").html("<div>error: " + msg + "</div>");
			},
			complete : function(){
				$('#loading-image').hide();
			}
		});
	}, 1200);
}

function showSendButton(){
	$("#enviar-button").show();
	$('#enviar-button').prop('disabled', true);
	$("#enviar-button").on("click", function(){
		sendCardsToBackEnd();
	});
}

$(document).ready(function(){
	$('#enviar-button').prop('disabled', true);
	$("#enviar-button").hide();
	$('#loading-image').hide();
	$('#contenedor-login').hide();
	$('#volver-button').hide();

	$('#submit-form-button').on('click', function(){
		submitForm();
	});

	$('.no-volver-button').on('click', function(){
		$('#volver-button').show();
	});

	$('#cadiz-button').on('click', function(){
		setting = 'cádiz';
		showSendButton();
		getCardsBySetting('cádiz');
	});
	$('#algeciras-button').on('click', function(){
		setting = 'algeciras';
		showSendButton();
		getCardsBySetting('algeciras');
	});
	
	$('#volver-button').on('click', function(){
		location.reload();
	});
	
	$('#entrar-button').on('click', function(){
		window.location.href = 'user-form.html';
	});
});