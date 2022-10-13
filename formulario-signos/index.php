<!DOCTYPE html>
<html>
<head>
	<title>Seu signo fácil - Resposta</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
	<style type="text/css">
    .bg-cover {
      background-attachment: static;
      background-position: center;
      background-repeat: no-repeat;
      background-size: cover;
    }
  </style>
</head>
<body>
<header class="bg-white">
  <h1 class="pb-2 mt-4 mb-2 text-center">Seu signo fácil</h1>
  <h5 class="pb-2 mt-4 mb-2 border-bottom text-center">Consultar seu signo nunca foi tão fácil</h5>
</header>
  <section class="container">
  	<?php
      if (empty($_GET["mes"]) || empty($_GET["dia"])) {
        echo '<script>location.href="./index.html";</script>';
        exit();
      } else {
  		$xml = simplexml_load_file('index.xml');
      $diaAtual = intval(date("z", strtotime("{$_GET["mes"]}/{$_GET["dia"]}"))+1);
  		foreach($xml->signo as $constelacao):
        list($diaInicio, $mesInicio) = explode("/", $constelacao->dataInicio);
        list($diaFinal, $mesFinal) = explode("/", $constelacao->dataFim);
        $diaInicio = intval(date("z", strtotime("{$mesInicio}/{$diaInicio}"))+1);
        $diaFinal = intval(date("z", strtotime("{$mesFinal}/{$diaFinal}"))+1);
        if (($diaAtual >= $diaInicio) && ($diaAtual <= $diaFinal) || ($constelacao->signoNome == 'Capricornus' && (($diaAtual >= $diaInicio) || ($diaAtual <= $diaFinal)))) {
          echo '<div class="jumbotron bg-cover" style="background-image: linear-gradient(to bottom, rgba(255,255,255,0.6) 0%,rgba(255,255,255,0.9) 100%), url(./images/' . $constelacao->signoNome . '.jpg)">';
          // echo '<img src="./images/' . $constelacao->signoNome . '.jpg" class="img-fluid">';
          echo '<p><b>Signo:</b> ' . $constelacao->signoNome . '</p>';
          echo '<p><b>Período entre: </b>' . $constelacao->dataInicio . ' e ' . $constelacao->dataFim . '</p>';
          echo '<p><b>Descrição:</b> ' . $constelacao->descricao . '</p>';
          echo '</div>';
        }
  		endforeach;
      }
  	?>
  </section>
  <footer class="border-top bg-white my-2">
    <ul>
      <li>Datas dos signos retiradas do site: <a href="https://astrologialuzesombra.com.br/datas-dos-signos-do-zodiaco/">Datas dos signos do Zodíaco e suas características - Astrologia Luz e Sombra</a></li>
      <li>Descrição dos signos retiradas do site: <a href="https://www.mapadomeuceu.com.br/blog/a-personalidade-dos-signos/">A personalidade dos signos - Mapa Do Céu</a></li>
      <li>Imagem dos signos retiradas do site: <a href="https://querobolsa.com.br/revista/signos-no-trabalho">Signos no trabalho: saiba como é o perfil profissional de cada signo do zodíaco - QueroBolsa</a></li>
      <li>Imagem citada na referencia anterior foi "cortada" pela ferramenta online: <a href="https://pinetools.com/split-image">SPLIT IMAGE ONLINE - PINETOOLS</a></li>
      <li>Configuração do ambiente com Docker Compose retirada do artigo: <a href="https://cursos.alura.com.br/forum/topico-criar-um-container-com-apache-e-php-105728">Criar um container com apache e php - Alura Fórum</a></li>
      <li>Método de inserção de html dentro do documento xml através do artigo: <a href="https://stackoverflow.com/questions/4412395/is-it-possible-to-insert-html-content-in-xml-document">Is it possible to insert HTML content in XML document? - stackoverflow</a></li>
    </ul>
  </footer>
</body>
</html>
