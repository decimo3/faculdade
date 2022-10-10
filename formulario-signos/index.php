<!DOCTYPE html>
<html>
<head>
	<title>Seu signo fácil - Resposta</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">

</head>
<body>
<header>
  <h1 class="pb-2 mt-4 mb-2 text-center">Seu signo fácil</h1>
  <h5 class="pb-2 mt-4 mb-2 border-bottom text-center">Consultar seu signo nunca foi tão fácil</h5>
</header>
  <section class="container">
  	<?php
  		$xml = simplexml_load_file('index.xml');
  		foreach($xml->zodiaco->signo as $constelacao):
  			if ($constelacao == $GET[signo]) {
  				
  			}
  		endforeach;
  	?>
  </section>
  <footer class="fixed-bottom border-top">
    <p>
    Imagem de fundo de <a href="https://pixabay.com/pt/users/openclipart-vectors-30363/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=160494">OpenClipart-Vectors</a> por <a href="https://pixabay.com/pt//?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=160494">Pixabay</a>
    </p>
  </footer>
</body>
</html>