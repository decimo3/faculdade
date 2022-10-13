<!DOCTYPE html>
<html>
<head>
	<title>Seu signo fácil - Resposta</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">

</head>
<body>
<header class="bg-white">
  <h1 class="pb-2 mt-4 mb-2 text-center">Seu signo fácil</h1>
  <h5 class="pb-2 mt-4 mb-2 border-bottom text-center">Consultar seu signo nunca foi tão fácil</h5>
</header>
  <section class="container">
  	<?php
  		$xml = simplexml_load_file('index.xml');
      $diaAtual = intval(date("z", strtotime("{$_GET["mes"]}/{$_GET["dia"]}"))+1);
  		foreach($xml->signo as $constelacao):
        list($diaInicio, $mesInicio) = explode("/", $constelacao->dataInicio);
        list($diaFinal, $mesFinal) = explode("/", $constelacao->dataFim);
        $diaInicio = intval(date("z", strtotime("{$mesInicio}/{$diaInicio}"))+1);
        $diaFinal = intval(date("z", strtotime("{$mesFinal}/{$diaFinal}"))+1);
        if (($diaAtual >= $diaInicio) && ($diaAtual <= $diaFinal) || ($constelacao->signoNome == 'Capricornus' && (($diaAtual >= $diaInicio) || ($diaAtual <= $diaFinal)))) {
          echo '<div class="row border border-dark rounded my-2 p-3 img-responsive">';
          echo '<div class="col-4">';
          echo '<img src="./images/' . $constelacao->signoNome . '.jpg" class="img-fluid">'; //
          echo '</div>';
          echo '<div class="col-8">';
          echo '<p>Signo: ' . $constelacao->signoNome . '</p>';
          echo '<p>Descrição: ' . $constelacao->descricao . '</p>';
          echo '</div>';
        }
  		endforeach;
  	?>
  </section>
  <footer class="border-top bg-white my-2">
    <p>
    Imagem de fundo de <a href="https://pixabay.com/pt/users/openclipart-vectors-30363/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=160494">OpenClipart-Vectors</a> por <a href="https://pixabay.com/pt//?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=160494">Pixabay</a>
    </p>
  </footer>
</body>
</html>