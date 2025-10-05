/**
 * Funções auxiliares
 */



async function getData(idSetor) {
    try {
        const response = await fetch( URL + "/setores/"+idSetor);
        if (!response.ok) {
            throw new Error("Network response was not ok " + response.statusText);
        }
        const data = await response.json();
		$.each(data, function(index, item) {
		           // Process each item in the array
		           console.log("Index: " + item.nome);
		           // You can access properties like item.id, item.name, etc.
		       });
    } catch (error) {
        console.error("There has been a problem with your fetch operation:", error);
    }
}


function formatarData(data) {	
	const dataAtual = new Date(data);
    const dia = String(dataAtual.getDate()).padStart(2, '0');
    const mes = String(dataAtual.getMonth() + 1).padStart(2, '0'); // Meses começam do zero
    const ano = dataAtual.getFullYear();
    const horas = String(dataAtual.getHours()).padStart(2, '0');
    const minutos = String(dataAtual.getMinutes()).padStart(2, '0');

    return `${dia}/${mes}/${ano} ${horas}:${minutos}`;
}


document.addEventListener("DOMContentLoaded", function(event) {
   
const showNavbar = (toggleId, navId, bodyId, headerId) =>{
const toggle = document.getElementById(toggleId),
nav = document.getElementById(navId),
bodypd = document.getElementById(bodyId),
headerpd = document.getElementById(headerId)

// Validate that all variables exist
if(toggle && nav && bodypd && headerpd){
toggle.addEventListener('click', ()=>{
// show navbar
nav.classList.toggle('show')
// change icon
toggle.classList.toggle('bx-x')
// add padding to body
bodypd.classList.toggle('body-pd')
// add padding to header
headerpd.classList.toggle('body-pd')


 
})
}
}

showNavbar('header-toggle','nav-bar','body-pd','header')

/*===== LINK ACTIVE =====*/
const linkColor = document.querySelectorAll('.nav_link')

function colorLink(){
if(linkColor){
linkColor.forEach(l=> l.classList.remove('active'))
this.classList.add('active')
}
}
linkColor.forEach(l=> l.addEventListener('click', colorLink))

 // Your code to run since DOM is loaded and ready
});


$(document).on('click', '[id^="download"]', function(event) {
    event.preventDefault(); 
    var recordId = $(this).data('record-id');
    var recordNome = $(this).data('record-nome');
		  $.ajax({
		        type: "GET",
		        url: URL + "/docs/files/download/" + recordId,
		        success: function(data)
		        {
		        	
		        	
		        }
		   });

});

function validarCPF(cpf) {
    // Remove todos os caracteres não numéricos
    cpf = cpf.replace(/\D/g, '');

    // Verifica se o CPF tem 11 dígitos ou se todos são iguais
    if (cpf.length !== 11 || /^(\d)\1{10}$/.test(cpf)) return false;

    // Validação do primeiro dígito verificador
    let soma = 0;
    for (let i = 0; i < 9; i++) {
        soma += parseInt(cpf[i]) * (10 - i);
    }
    let resto = soma % 11;
    const digito1 = resto < 2 ? 0 : 11 - resto;

    // Validação do segundo dígito verificador
    soma = 0;
    for (let i = 0; i < 10; i++) {
        soma += parseInt(cpf[i]) * (11 - i);
    }
    resto = soma % 11;
    const digito2 = resto < 2 ? 0 : 11 - resto;

    // Retorna true se os dígitos verificadores são válidos
    return (
        digito1 === parseInt(cpf[9]) && digito2 === parseInt(cpf[10])
    );
}

/*
$(document).on('click', '[id^="download"]', function(event) {
    event.preventDefault(); 
    var recordId = $(this).data('record-id');
    var recordNome = $(this).data('record-nome');
	alert(recordNome)
    swal({
	  title: 'Excluir nomeação?',
	  text: "Deseja excluir a função do(a) mesário(a) " + recordNome + "?",
	  icon: 'warning',
	  buttons: [true, "Sim Excluir!"]
	}).then((result) => {
	  if (result) {
		  $.ajax({
		        type: "GET",
		        url: URL + "docs/files/download/" + recordId,
		        success: function(data)
		        {
		        	swal("Atenção",data.response,data.status.toLowerCase());
		        	if (data.status == "SUCCESS"){
		        	   $("#tr"+recordId).remove();
		        	}
		        }
		   });
	   }
   }); // fim SWAL 
});
 */