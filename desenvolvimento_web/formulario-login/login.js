function limparCampos () {
	var usuario = document.getElementsByName("usuario")[0];
	var palavra = document.getElementsByName("palavra")[0];
	if ((usuario.value.length > 0) || (palavra.value.length > 0)) {
		if (confirm("Tem certeza que deseja cancelar o preenchimento do formulário?")){
		usuario.value = palavra.value = "";
		console.warn("O formulário foi limpo com sucesso!");
		}
	}
}
function enviarFormulario (event) {
	event.preventDefault();
	var usuario = document.getElementsByName("usuario")[0];
	var palavra = document.getElementsByName("palavra")[0];
	if ((usuario.value.length > 0) && (palavra.value.length > 0)) {
		localStorage.setItem("usuario", usuario.value);
		window.location.replace("./wellcome.html");
	} else {
		alert("O nome de usuário e senha não são válidos!\nConferir se os valores foram digitados corretamente!");
	}
}
