function alterarFontClass(){
	$("table").attr("class","linksVermelhos");
}

$("button").on("click",function(event) {
	alterarFontClass();
});