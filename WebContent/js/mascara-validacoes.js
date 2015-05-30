$().ready(function(){
//	jQuery.validator.setDefaults({
//		debug:true,
//		success:"valid"
//	});
	$("#formAdicionaCaloteiro").validate({
		rules:{
			nome:{
				required:true,
				maxlength:45
			},
			email:{
				required:true,
				email:true
			},
			dataDivida:{
					required:true,
			}
		},
		messages:{
			nome:{
				required: "Esse campo é obrigatorio.",
				maxlength: "O campo nome não pode ter mais que 45 caracteres"
			},
			email:{
				required: "Esse campo é obrigatorio",
				email: "Esse cara não é um email valido."
			},
			dataDivida:{
				required:"Esse campo é obrigatorio",
			}
		}
	});
	
	$("#labelDevendo").maskMoney();
	
	$("#labelData").mask("99/99/9999");
	
	$("#formAdicionaCaloteiro").submit(function(event) {
		$("#labelDevendo").maskMoney("destroy");
	});
	
});