$(".search-product").on("click", function(){
    $(".search-product").addClass("font-aqua");
    $(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function(){
    $(".search-service").addClass("font-aqua");
    $(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function(event){
    $(".banner a").removeClass("border-b");
    $(event.target).addClass("border-b");
})

$(".content-nav li").on("click", function(event){
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})

$(function()
	{
		var id = sessionStorage.getItem("cusid");
		var	phone = sessionStorage.getItem("cusphone");
		console.log(id,phone);
		$.ajax({
			type : "post",
			url : "/customer/product",
			data : {
				id:id,
				phone:phone,
			},
			dataType : "json",
			success : function(data) {
				/*alert(data.state);
				if (data.status == 1) {

					console.log(data.id, data.phone);
					sessionStorage.setItem("cusphone", data.phone);
					sessionStorage.setItem("cusid", data.id);
					location.href = "toPage?url=e-commerce_product.html";*/

				}
				console.log("成功", data);
			},
			error : function(data) {
				console.log("失败", data);
			}
		})
	
	
	})