var $=function(id){
	return document.getElementById(id);
};

window.onload= function(){
	var listNode=$("imageList");
	var captionNode = $("caption");
	var imageNode=$("imageNode");
	
	var imageLinks = document.getElementsByTagName("a");
	
	var i , linkNode, image;
	for(i=0;i<imageLinks.length;i++)
	{
		linkNode=imageLinks[i];		
		linkNode.onclick = function(evt){
			
			var link = this;
			imageNode.src=link.getAttribute("href");
			captionNode.firstChild.nodeValue=link.getAttribute("title");
			
			if(!evt){evt=window.event;}
			if(evt.preventDefault){
				evt.preventDefault();
			}
			else{
				evt.returnValue=false;
			}
			
			image=new Image();
			image.src=linkNode.getAttribute("href");
		};
	}
	$("firstLink").focus();
};