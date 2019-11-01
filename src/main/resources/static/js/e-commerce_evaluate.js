$(function()
		{
			var user = sessionStorage.getItem("cusphone");
			var txt = "";
			txt += `<span >${user}</span>`;
			$("#user").append(txt);
	
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

$(".user-action a").on("click", function(event){
    $(".user-action a").removeClass("bg-gray");
    $(event.target).addClass("bg-gray");
})
$(".content-nav li").on("click", function(event){
    $(".content-nav li").removeClass("nav-active");
    $(event.target).addClass("nav-active");
})
$(".evaluate_btn").on("click", function(event){
    $(".masking").show();
})
$(".save").on("click", function(event){
    $(".masking").hide();
    console.log("保存");
})
$(".cancel").on("click", function(event){
    $(".masking").hide();
    console.log("取消");
})

function hasevaluate(){
	var id = sessionStorage.getItem("cusid");
	$.ajax({
		type : "post",
		url : "/customer/hasevaluate",
		data:{id:id},
		dataType : "json",
		success : function(data) {
			console.log("成功", data);
			orderevalist(data);
			// location.href = "toPage?url=e-commerce_order.html";
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
}
function notevaluate(){
	var id = sessionStorage.getItem("cusid");
	$.ajax({
		type : "post",
		url : "/customer/notevaluate",
		data:{id:id,},
		dataType : "json",
		success : function(data) {
			console.log("成功", data);
			orderevalist(data);
			// location.href = "toPage?url=e-commerce_order.html";
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
}

function orderevalist(data)
{
	var list = data.list;
	var txt = "";
	$(".list").append().html("");
	
	if(list!=null){
		for(var i = 0;i<list.length;i++)
		{
		txt+=`
		<div class = "article">
		<img src="" alt="图片" />
        <ul class="article-info">
            <li>${list[i].ordeProduct}</li>
            <li>${data[list[i].ordeProduct]}</li>
            <li>${list[i].ordeProvidername}</li>
        </ul>
        <p>购买时间：${datetime(list[i].ordeStarttime)}</p>
        <p class="evaluate_btn" >去评价</p>
         </div><hr color="#ccc" size="1">`
		
		}
	$(".list").append(txt);}
	else{
		alert(data.state);
	}
	
	
	/*<img src="" alt="图片" />
        <ul class="article-info">
            <li>代理记账（一年）</li>
            <li>适用于没有经营性业务的企业，代理记账服务</li>
            <li>云智汇咨询服务有限公司</li>
        </ul>
        <p>购买时间：2017-02-23 23:23:34</p>
        <p class="evaluate_btn">去评价</p>*/
}
function datetime(time) {
	var date = new Date(time);
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
			+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
			+ ":" + date.getSeconds();
}
