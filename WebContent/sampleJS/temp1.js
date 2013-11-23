$(document).ready(function() {
	$("h2").click(
	function(){
		$(this).toggleClass("minus");
		$(this).next().slideToggle(400);
	});	//end click
}); //end ready
