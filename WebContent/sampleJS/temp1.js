$(document).ready(function() {
	$("#mybutton").click(function(){
		$("#mylabel + input").val("Hello this is from JS");
	});
	
	$(":text").dblclick(function() {
		$(this).val("ngfgfgnf");
	});
	
});