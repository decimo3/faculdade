window.onload = () => {
	var mensagem = document.getElementById("mensagem");
	var valor = localStorage.getItem("usuario");
	if (!valor) {
		window.location.replace("./login.html");
	}
	if (valor) mensagem.innerText = `Seja bem-vindo a área do usuário, ${valor}!`;
}
function desconectarConta () {
	localStorage.clear();
	window.location.replace("./login.html");
}