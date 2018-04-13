
<?php
  $user = 'a0750881';
  $pass = 'coala';
  $database = 'lab';
 
  // establish database connection
  $conn = oci_connect($user, $pass, $database);
  if (!$conn) exit;
?>

<html>
<head>
</head>
<body>


// FAHRSCHULZENTRUM

  <div>
      <form id='searchform' action='index.php' method='get'>
      <a href='index.php'>Alle Fahrschulzentren (fzid)</a> ---
      Suche nach : 
	  
      	<input id='search' name='search' type='text' size='20' value='<?php echo $_GET['search']; ?>' />
      	<input id='submit' type='submit' value='Suchen!' />

      </form>  
  </div>

<?php
  // check if search view of list view
  if (isset($_GET['search'])) {
    $sql = "SELECT * FROM fahrschulzentrum WHERE fzid like '%" . $_GET['search'] . "%'";
  } else {
    $sql = "SELECT * FROM fahrschulzentrum ";
  }

  // execute sql statement
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);
?>

  <table style='border: 1px solid #DDDDDD'>
    <thead>
      <tr>
        <th>fzid</th>
        <th>fzname</th>
        <th>plz</th>
        <th>land</th>
      </tr>
    </thead>
    <tbody>
<?php
  // fetch rows of the executed sql query
  while ($row = oci_fetch_assoc($stmt)) {
    echo "<tr>";
    echo "<td>" . $row['FZID'] . "</td>";
    echo "<td>" . $row['FZNAME'] . "</td>";
    echo "<td>" . $row['PLZ'] . "</td>";
    echo "<td>" . $row['LAND'] . "</td>";
    echo "</tr>";
  }
?>
    </tbody>
  </table>
<div>Insgesamt <?php echo oci_num_rows($stmt); ?> fahrschulzentren gefunden!</div>




// GEBAEUDE

  <div>
      <form id='searchform' action='index.php' method='get'>
      <a href='index.php'>Alle Gebaeude (gbname)</a> ---
      Suche nach : 
	  
      	<input id='search' name='search' type='text' size='20' value='<?php echo $_GET['search']; ?>' />
      	<input id='submit' type='submit' value='Suchen!' />

      </form>  
  </div>

<?php
  // check if search view of list view
  if (isset($_GET['search'])) {
    $sql = "SELECT * FROM gebaeude WHERE gbname like '%" . $_GET['search'] . "%'";
  } else {
    $sql = "SELECT * FROM gebaeude ";
  }

  // execute sql statement
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);
?>

  <table style='border: 1px solid #DDDDDD'>
    <thead>
      <tr>
        <th>gebaeudenr</th>
        <th>gbname</th>
        <th>adresse</th>
        <th>fzid</th>
      </tr>
    </thead>
    <tbody>
<?php
  // fetch rows of the executed sql query
  while ($row = oci_fetch_assoc($stmt)) {
    echo "<tr>";
    echo "<td>" . $row['GEBAEUDENR'] . "</td>";
    echo "<td>" . $row['GBNAME'] . "</td>";
    echo "<td>" . $row['ADRESSE'] . "</td>";
    echo "<td>" . $row['FZID'] . "</td>";
    echo "</tr>";
  }
?>
    </tbody>
  </table>
<div>Insgesamt <?php echo oci_num_rows($stmt); ?> gebaeude gefunden!</div>




// MITARBEITER

  <div>
      <form id='searchform' action='index.php' method='get'>
      <a href='index.php'>Alle Mitarbeiter (maname)</a> ---
      Suche nach : 
	  
      	<input id='search' name='search' type='text' size='20' value='<?php echo $_GET['search']; ?>' />
      	<input id='submit' type='submit' value='Suchen!' />

      </form>  
  </div>

<?php
  // check if search view of list view
  if (isset($_GET['search'])) {
    $sql = "SELECT * FROM mitarbeiter WHERE maname like '%" . $_GET['search'] . "%'";
  } else {
    $sql = "SELECT * FROM mitarbeiter ";
  }

  // execute sql statement
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);
?>

  <table style='border: 1px solid #DDDDDD'>
    <thead>
      <tr>
        <th>personalnr</th>
        <th>maname</th>
        <th>svnr</th>
        <th>gehalt</th>
        <th>fzid</th>
      </tr>
    </thead>
    <tbody>
<?php
  // fetch rows of the executed sql query
  while ($row = oci_fetch_assoc($stmt)) {
    echo "<tr>";
    echo "<td>" . $row['PERSONALNR'] . "</td>";
    echo "<td>" . $row['MANAME'] . "</td>";
    echo "<td>" . $row['SVNR'] . "</td>";
    echo "<td>" . $row['GEHALT'] . "</td>";
    echo "<td>" . $row['FZID'] . "</td>";
    echo "</tr>";
  }
?>
    </tbody>
  </table>
<div>Insgesamt <?php echo oci_num_rows($stmt); ?> mitarbeiter gefunden!</div>




// ARBEITSZIMMER

  <div>
      <form id='searchform' action='index.php' method='get'>
      <a href='index.php'>Alle Arbeitszimmer (azname)</a> ---
      Suche nach : 
	  
      	<input id='search' name='search' type='text' size='20' value='<?php echo $_GET['search']; ?>' />
      	<input id='submit' type='submit' value='Suchen!' />

      </form>  
  </div>

<?php
  // check if search view of list view
  if (isset($_GET['search'])) {
    $sql = "SELECT * FROM arbeitszimmer WHERE azname like '%" . $_GET['search'] . "%'";
  } else {
    $sql = "SELECT * FROM arbeitszimmer ";
  }

  // execute sql statement
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);
?>

  <table style='border: 1px solid #DDDDDD'>
    <thead>
      <tr>
        <th>arbeitsznr</th>
        <th>azname</th>
        <th>einrichtung</th>
        <th>gebaeudenr</th>
        <th>personalnr</th>
      </tr>
    </thead>
    <tbody>
<?php
  // fetch rows of the executed sql query
  while ($row = oci_fetch_assoc($stmt)) {
    echo "<tr>";
    echo "<td>" . $row['ARBEITSZNR'] . "</td>";
    echo "<td>" . $row['AZNAME'] . "</td>";
    echo "<td>" . $row['EINRICHTUNG'] . "</td>";
    echo "<td>" . $row['GEBAEUDENR'] . "</td>";
    echo "<td>" . $row['PERSONALNR'] . "</td>";
    echo "</tr>";
  }
?>
    </tbody>
  </table>
<div>Insgesamt <?php echo oci_num_rows($stmt); ?> arbeitszimmer gefunden!</div>




// FAHRKURS

  <div>
      <form id='searchform' action='index.php' method='get'>
      <a href='index.php'>Alle Fahrkurse (beginnzeit)</a> ---
      Suche nach : 
	  
      	<input id='search' name='search' type='text' size='20' value='<?php echo $_GET['search']; ?>' />
      	<input id='submit' type='submit' value='Suchen!' />

      </form>  
  </div>

<?php
  // check if search view of list view
  if (isset($_GET['search'])) {
    $sql = "SELECT * FROM fahrkurs WHERE beginnzeit like '%" . $_GET['search'] . "%'";
  } else {
    $sql = "SELECT * FROM fahrkurs ";
  }

  // execute sql statement
  $stmt = oci_parse($conn, $sql);
  oci_execute($stmt);
?>

  <table style='border: 1px solid #DDDDDD'>
    <thead>
      <tr>
        <th>kursnr</th>
        <th>tagesdatum</th>
        <th>beginnzeit</th>
        <th>endzeit</th>
        <th>kundennr</th>
      </tr>
    </thead>
    <tbody>
<?php
  // fetch rows of the executed sql query
  while ($row = oci_fetch_assoc($stmt)) {
    echo "<tr>";
    echo "<td>" . $row['KURSNR'] . "</td>";
    echo "<td>" . $row['TAGESDATUM'] . "</td>";
    echo "<td>" . $row['BEGINNZEIT'] . "</td>";
    echo "<td>" . $row['ENDZEIT'] . "</td>";
    echo "<td>" . $row['KUNDENNR'] . "</td>";
    echo "</tr>";
  }
?>
    </tbody>
  </table>
<div>Insgesamt <?php echo oci_num_rows($stmt); ?> fahrkurse gefunden!</div>





// ZUSATZ: BEFUELLUNG INSERT UEBER FORMULARFELDER

<div>
  <form id='insertform' action='index.php' method='get'>
    Neues fahrschulzentrum einfuegen:
	<table style='border: 1px solid #DDDDDD'>
	  <thead>
	    <tr>
	      <th>fzid</th>
	      <th>fzname</th>
	      <th>plz</th>
	      <th>land</th>
	    </tr>
	  </thead>
	  <tbody>
	     <tr>
	        <td>
	           <input id='fzid' name='fzid' type='text' size='10' value='<?php echo $_GET['fzid']; ?>' />
                </td>
                <td>
                   <input id='fzname' name='fzname' type='text' size='20' value='<?php echo $_GET['fzname']; ?>' />
                </td>
		<td>
		   <input id='plz' name='plz' type='text' size='20' value='<?php echo $_GET['plz']; ?>' />
		</td>
		<td>
		   <input id='land' name='land' type='text' size='20' value='<?php echo $_GET['land']; ?>' />
		</td>
	     </tr>
           </tbody>
        </table>
        <input id='submit' type='submit' value='Insert durchfuehren!' />
  </form>
</div>

<?php
  //Handle insert
  if (isset($_GET['fzid'])) 
  {
    //Prepare insert statement
    $sql = "INSERT INTO fahrschulzentrum VALUES(" . $_GET['fzid'] . ",'"  . $_GET['fzname'] . "'," . $_GET['plz'] . ",'" . $_GET['land'] . "')";
    //Parse and execute statement
    $insert = oci_parse($conn, $sql);
    oci_execute($insert);
    $conn_err=oci_error($conn);
    $insert_err=oci_error($insert);
    if(!$conn_err & !$insert_err){
	print("Successfully INSERTED");
 	print("<br>");
    }
    //Print potential errors and warnings
    else{
       print($conn_err);
       print_r($insert_err);
       print("<br>");
    }
    oci_free_statement($insert);
  } 
?>



// ZUSATZ: ERSTELLUNG EINER STORED PROCEDURE

<div>
  <form id='searchaznr' action='index.php' method='get'>
    Suche Arbeitszimmernummer zu bestimmtem Mitarbeiter (personalnr):
      <input id='personalnr' name='personalnr' type='text' size='20' value='<?php echo $_GET['personalnr']; ?>' />
      <input id='submit' type='submit' value='Aufruf Stored Procedure!' />
  </form>
</div>


<?php
 //Handle Stored Procedure
 if (isset($_GET['personalnr']))
 {
    //Call Stored Procedure  
    $personalnr = $_GET['personalnr'];
    $arbeitsznr='';
    $sproc = oci_parse($conn, 'begin personalnr_arbeitsznr(:p1, :p2); end;');
    //Bind variables, p1=input (personalnr), p2=output (arbeitsznr)
    oci_bind_by_name($sproc, ':p1', $personalnr);
    oci_bind_by_name($sproc, ':p2', $arbeitsznr, 20);
    oci_execute($sproc);
    $conn_err=oci_error($conn);
    $proc_err=oci_error($sproc);
    //If there have been no Connection or Database errors, print department
    if(!$conn_err && !$proc_err){
       echo("<br><b>" . $personalnr . " arbeitet in Arbeitszimmer mit Nummer " . $arbeitsznr . "</b><br>" );  // prints OUT parameter of stored procedure
    }
    else{
      //Print potential errors and warnings
      print($conn_err);
      print_r($proc_err);
    }  
 }
 // clean up connections
 oci_free_statement($sproc);
 oci_close($conn);
?>







<?php  oci_free_statement($stmt); ?>  
  // clean up connections
  oci_free_statement($sproc);
  oci_close($conn);
?>

</body>
</html>
