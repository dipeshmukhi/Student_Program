$(document).ready(function(){
	var imageCache = [];
	$("img").each(function(){
		var image = new Image();
		image.src = $(this).attr("src");
		image.title=$(this).attr("alt");
		imageCache.push(image);
	});
	
	$("h1").click(function(){
		$(this).animate(
				{ fontSize: "+=100" , opacity: 1, left: "175" },
				  2000).
				  animate(
							{ fontSize: "-=50" , opacity: 1, left: "175" },
							  2000
							);
	});
	
	
	var imageCounter=0;
	var currentImage;
	setInterval(function(){
		$("#caption").fadeOut(1000);
		$("#main").fadeOut(1000, function(){
			imageCounter=(imageCounter +1) % imageCache.length;
			currentImage = imageCache[imageCounter];
			$("#caption").text(" " +imageCounter).fadeIn(1000);
			$("#main").attr("src",currentImage.src).fadeIn(1000);			
		});
	}, 3000);
});