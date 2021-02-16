<!DOCTYPE html>
<html >
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
* {
  box-sizing: border-box; 
}

body {
  font-family: Helvetica, sans-serif;
}

/* The actual timeline */
.timeline {
  position: relative;
  max-width: 1200px;
  margin: 0 auto;
}

/* The actual timeline (the vertical ruler) */
.timeline::after {
  content: '';
  position: absolute;
  width: 6px;
  background-color: #333;
  top: 0;
  bottom: 0;
  left: 50%;
  margin-left: -3px;
}

/* Container around content */
.container {
  padding: 10px 40px;
  position: relative;
  background-color: inherit;
  width: 50%;
}

/* The circles on the timeline */
.container::after {
  content: '';
  position: absolute;
  width: 25px;
  height: 25px;
  right: -17px;
  background-color: white;
  border: 4px solid #ff6600;
  top: 15px;
  border-radius: 50%;
  z-index: 1;
}

/* To place the container to the left */
.left {
  left: 0;
}

/* To place the container to the right */
.right {
  left: 50%;
}

/* Add arrows to the left container (pointing right) */
.left::before {
  content: " ";
  height: 0;
  position: absolute;
  top: 22px;
  width: 0;
  z-index: 1;
  right: 30px;
  border: medium solid #333;
  border-width: 10px 0 10px 10px;
  border-color: transparent transparent transparent #333;
}

/* Add arrows to the right container (pointing left) */
.right::before {
  content: " ";
  height: 0;
  position: absolute;
  top: 22px;
  width: 0;
  z-index: 1;
  left: 30px;
  border: medium solid #333;
  border-width: 10px 10px 10px 0;
  border-color: transparent #333 transparent transparent;
}

/* Fix the circle for containers on the right side */
.right::after {
  left: -16px;
}

/* The actual content */
.content {
  padding: 20px 30px;
  background-color: #333;
  color: white;
  position: relative;
  border-radius: 6px;
}

/* Media queries - Responsive timeline on screens less than 600px wide */
@media screen and (max-width: 600px) {
  /* Place the timelime to the left */
  .timeline::after {
  left: 31px;
  }
  
  /* Full-width containers */
  .container {
  width: 100%;
  padding-left: 70px;
  padding-right: 25px;
  }
  
  /* Make sure that all arrows are pointing leftwards */
  .container::before {
  left: 60px;
  border: medium solid white;
  border-width: 10px 10px 10px 0;
  border-color: transparent white transparent transparent;
  }

  /* Make sure all circles are at the same spot */
  .left::after, .right::after {
  left: 15px;
  }
  
  /* Make all right containers behave like the left ones */
  .right {
  left: 0%;
  }
}
</style>
</head>
<body>
  

<div class="timeline">
  <div class="container left">
    <div class="content">
      <h2>2019</h2>
      <p>Started school at University of Illinois at Chicago</p>
    </div>
  </div>
  <div class="container right">
    <div class="content">
      <h2>2019</h2>
      <p>Left job at Oracle Financial Services Software Ltd.</p>
    </div>
  </div>
  <div class="container left">
    <div class="content">
      <h2>2017</h2>
      <p>Started working at Oracle Financial Services Software Ltd.</p>
    </div>
  </div>
  <div class="container right">
    <div class="content">
      <h2>2017</h2>
      <p>Graduated from DJ Sanghvi College of Engineering</p>
    </div>
  </div>

</div>

</body>
</html>
