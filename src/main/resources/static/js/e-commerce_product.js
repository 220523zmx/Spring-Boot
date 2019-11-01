$(function(){
	var user = sessionStorage.getItem("cusphone");
	var txt = "";
	txt += `${user}`;
	$("#user").append(txt);
})
function productlist(data)
{
	var productlist = data.productlist;
	var  txt = "";
	$(".product").append().html("");
	for(var i = 0;i < productlist.length;i++){
		var providerid = productlist[i].servProviderid;
		txt +=`
			<div class="article">
				<img src="" alt="图片" />
				<ul class="article-info" value = "${productlist[i].servProductid}">
					<li>${productlist[i].servProductname}</li>
					<li>${productlist[i].servInstructions}</li>
					<li>${productlist[i].servProvidername}</li>
				</ul>
				<ul class="article-price">
					<li >￥ ${productlist[i].servPrice}</li>
					<li>
						<span onclick="just_buy('${productlist[i].servProductid}','${providerid}','${productlist[i].servPrice}')">立即购买</span>
            			<span onclick="add_cart('${productlist[i].servProductid}','${providerid}','${productlist[i].servPrice}')">加入购物车</span>
					</li>
				</ul>
			</div>
			<hr color="#ededed" size="1">`		
	}
	$(".product").append(txt);
}
$(function(){
	$.ajax({
		type : "post",
		url : "/customer/product",
		dataType : "json",
		success : function(data) {
			console.log("成功",data);
			productlist(data);
		},
		error : function(data) {
			console.log("失败",data);
		}
	})		
})
$(function(){
	var a = 0;
	$("#privice").click(
			function(){
				a++;
				if(a%2 != 0){
					// 升序
					$.ajax({
						type : "post",
						url : "/customer/priceEsc",
						dataType : "json",
						success : function(data) {
							console.log("成功",data);
							productlist(data);
						},
						error : function(data) {
							console.log("失败",data);
						}
					})		
				}
				else{
					// 降序
					$.ajax({
						type : "post",
						url : "/customer/priceDesc",
						dataType : "json",
						success : function(data) {
							console.log("成功",data);
							productlist(data);
						},
						error : function(data) {
							console.log("失败",data);
						}
					})
				}		
			});
});
$(".nav-active").on("click",function(){
	$.ajax({
		type : "post",
		url : "/customer/numberDesc",
		dataType : "json",
		success : function(data) {
			console.log("成功",data);
			productlist(data);
			
		},
		error : function(data) {
			console.log("失败",data);
		}
	})		
		
})
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
function add_cart(procid,provid,procprice)
{
	var pcid = procid;
	var pvid = provid;
	var pcpri = procprice;
	var cuid = sessionStorage.getItem("cusid");
	$.ajax({
		type : "post",
		url : "/customer/add_cart",
		data:{
			cuid: cuid,
			pcid: pcid,
			pvid: pvid,
			pcpri:pcpri,
		},
		dataType : "json",
		success : function(data) {
			console.log("成功",data);
		},
		error : function(data) {
			console.log("失败",data);
		}
		
})
}
function just_buy(procid,provid,procprice)
{
	var pcid = procid;
var pvid = provid;
var pcpri = procprice;
var cuid = sessionStorage.getItem("cusid");
$.ajax({
	type : "post",
	url : "/customer/just_buy",
	data:{
		cuid: cuid,
		pcid: pcid,
		pvid: pvid,
		pcpri:pcpri,
	},
	dataType : "json",
	success : function(data) {
		console.log("成功",data);
		sessionStorage.setItem("topay",data.str);
		location.href="toPage?url=e-commerce_settlement.html"
	},
	error : function(data) {
		console.log("失败",data);
	}
	
})
	
}


