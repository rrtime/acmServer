
	function show(e,a){
		var tab=e;
		var shu=a;
		if(tab==1){
			$(".answer ul li span").html(shu);
			$(".answer").show();
			$(".fault").hide();
		}else{
			$(".fault ul li span").html(shu);
			$(".answer").hide();
			$(".fault").show();
		}
	}
	//show(1,"在线客服")
