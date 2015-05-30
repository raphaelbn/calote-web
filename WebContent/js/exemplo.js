$(document).ready(
		function() {
			function meuAlerta() {
				var msg = $("#msg").val();
				$("#msgResposta").text(msg);
			}
			$("button").on("click", function(event) {
				meuAlerta();
			});
		}
);