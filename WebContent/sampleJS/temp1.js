$(document).ready(function(){
	$("#imageList a").hover(
			function(event){
				event.preventDefault();
				$(this).stop(true).animate({top:15},"fast");
			},
			function(event){
				event.preventDefault();
				$(this).stop(true).animate({top:0},"fast");
			}
	);
});

