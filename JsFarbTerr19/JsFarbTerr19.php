<!DOCTYPE html> 
<html>
 <head>
<meta charset="utf-8"/>
 <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
 <link rel="stylesheet" href="../../formate.css" type="text/css">
<link rel="icon" href="../../apfel.png" sizes="32x32" />
 <title>Bunte Quadrate</title>
 <script type="text/javascript" src="JsFarbTerr19.js"></script>
 </head>
<body onload="losGehts()" class="bar" >
<a href="../../index.html"><h2>Home</h2></a><br>
<div class="zent1">
<form name="menu" method="post" action="JsFarbTerr19.php" >
<select class="seldrei" size=1 name="gros">
<optgroup label="Gr&ouml;&szlig;e">
<option value="4">4 x 4</option>
<option value="8">8 x 8</option>
<option value="16">16 x 16</option>
<option value="32">32 x 32</option>
</optgroup>
</select>
<select class="seldrei" size=1 name="zeit">
<optgroup label="Zeitschritt">
<option value="100">100 ms</option>
<option value="200">200 ms</option>
<option value="400">400 ms</option>
<option value="800">800 ms</option>
</optgroup>
</select>
<input type=submit value="Los!">
</form>
</div>
<p id ="pu">
<?php
if (isset($_POST['gros'])){
$miau=$_POST['gros'];
$anna=$_POST['zeit'];
echo "$miau x $miau <br>";
$brei= 24 * $miau - 8;
echo "$anna ms";
}
?>
</p>
<script>
var hori = <?php echo "$brei"?>;
var zeis = <?php echo "$anna"?>;
</script>
<div class="zent3">

   <canvas id="AnimFaT" width=<?php echo "$brei"?> height=<?php echo "$brei"?>></canvas> 

</div>
  </body>
</html>
