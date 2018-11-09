<!DOCTYPE html>
<html>
<head>
<script>
var myImage = document.getElementById("mainImage");
var imageArray =["1.jpg", "2.jpg", "3.jpg"];
var imageIndex = 0;

function changeImage()
{
	myImage.setAttribute("src",imageArray[imageIndex]);
	imageIndex++;
	if(imageIndex>=imageArray.length)
	{
		imageIndex=0;	
	}
	
}
setInterval(changeImage, 3000);
</script>
</head>
<body>
<img src="4.jpg" id=mainImage alt="cat" style="width=120px;height:90px;">
</body>
</html>