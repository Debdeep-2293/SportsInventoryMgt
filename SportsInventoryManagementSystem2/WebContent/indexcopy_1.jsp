<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ipsita Ghatak</title>
	<style>
html {
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0px;
    padding: 0px;
  }
  
  .fa {
    padding: 20px;
    font-size: 30px;
    width: 30px;
    text-align: center;
    text-decoration: none;
    border-radius: 50%;
  }
  
  /* To add a hover effect*/
  .fa:hover {
    opacity: 0.7;
  }
  
  /* Set a color for each icon */
  
  /* Instagram*/
  .fa-instagram{
    background:  #333;
    color: white;
  }
  
  /* Linkedin */
  .fa-linkedin {
    background:  #333;
    color: white;
  }
  .card {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    width: 20%;
    height:40%;
    border-radius: 5px; /* 5px rounded corners */
  }
  
  /* To add rounded corners to the top left and the top right corner of the image */
  img {
    border-radius: 2px 2px 0 0;
  }
  /* On mouse-over, add a deeper shadow */
  .card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
  }
  
  /* Add some padding inside the About me container */
  .container ,.right{
    padding: 2px 16px;
  }
  .wrapper {
    
    max-width: 80%;
    display: flex;
    flex-direction: row;
    height: 100%;
    
     margin: auto;
  }
  .card, .right {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    background-color:  #333;;
    color: white;
    margin: 5px;
    max-width: 50%;
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: center;
    
  }
  .topnav {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    overflow: hidden;
    background-color:#f2f2f2 ;
    max-width: 80%;
    margin: auto;
  }
  
  .topnav a {
    float: left;
    color:  #333;;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    font-size: 17px;
  }
  
  .topnav a:hover {
    background-color: #ddd;
    color: black;
  }
  
  .topnav a.active {
    background-color: #333;
    color: white;
  }
  /* Style the footer */
.footer {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    background-color: #333;
    color: white;
    text-align: center;
    max-width: 80%;
    margin:auto
  }
</style>
</head>
<body>
  <div class="topnav">
    <a class="active" href="indexcopy.jsp">Home</a>
    <a href="timeline.jsp">Timeline</a>
	<a href="http://localhost:8085/jsp-servlet-jdbc-mysql/new">Demo</a>
  </div>
    <div class="wrapper">
        <div class="card">
		<img src="ipsita.jpg">
            <div class="container">
              <h4><b>Ipsita Ghatak</b></h4>
              <p>MIS Student</p>
            </div>
          </div>
        <div class="right">
            <p class="bio">
                Hi there! My name is Ipsita Ghatak and I was born and raised in Mumbai. I have two years of experience working as an Associate Consultant at Oracle Financial Services. I am currently pursuing Masters in Management Information Systems at University of Illinois at Chicago.
<br><br>
In my spare time, I enjoy painting and playing tennis. I also love travelling and exploring new places.
<br><br>
Thanks for reading along!
<br><br>
Ipsita

              </p>
                 
        </div> 
    </div>
    <div class="footer">
      <a href="https://www.instagram.com/ipsitaghatak/" class="fa fa-instagram"></a>
     <a href="https://www.linkedin.com/in/ipsitaghatak/" class="fa fa-linkedin"></a>  
    </div>
        
</body>
</html>