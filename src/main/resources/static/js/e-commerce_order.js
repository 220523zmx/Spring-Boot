$(function() {
	var user = sessionStorage.getItem("cusphone");
	var txt = "";
	txt += `<span >${user}</span>`;
	$("#user").append(txt);
})

 
$(function() {
	var id = sessionStorage.getItem("cusid");
	$.ajax({
				type : "post",
				url : "/customer/order",
				dataType : "json",
				data : {
					id : id,
				},
				success : function(data) {
					console.log("成功", data);
					var txt = "";
					var list = data.orderid;
					$(".orderinformation").append().html("");
					for (var i = 0; i < list.length; i++) {
						var line = data[list[i]];
						txt += `
						<div class="order-num">
							订单号: ${list[i]}下单时间： ${datetime(line[0].ordeStarttime)}
						</div>
							`
						for (var j = 0; j < line.length; j++) {
							txt +=`
							<ul class="order-details"> 
								<li> 
									<img src="./images/user-lg.png" alt="图片">
									<ul> 
										<li>${line[j].ordeProvidername}</li> 
										<li>${line[j].ordeProduct}</li>
									</ul> 
									<p>¥${line[j].ordePrice}</p> 
									<p>${line[j].ordeNum}</p>
								</li> 
								<li class="font-aqua">¥${line[j].ordePrice*line[j].ordeNum}</li>`
							if (line[j].ordeState == 0) {
								txt+=`
									<li class="font-aqua">等待买家付款</li> 
									<li> 
										<p onclick="pay(${list[i]})">付款</p>
										<span onclick = "deleteorderline('${list[i]}','${line[j].ordeProduct}')">删除订单</span> 
									</li>
								</ul>
								
								<hr color="#ededed" size="1">`
							} else {
								txt+=`
									<li class="font-aqua">已付款</li> 
									<li>交易完成</li> 
								</ul>
								<hr color="#ededed" size="1">`

							}
						}
					}

					$(".orderinformation").append(txt);
				},
				error : function(data) {
					console.log("失败", data);
				}
			})

})

$(".search-product").on("click", function() {
	$(".search-product").addClass("font-aqua");
	$(".search-service").removeClass("font-aqua");
})
$(".search-service").on("click", function() {
	$(".search-service").addClass("font-aqua");
	$(".search-product").removeClass("font-aqua");
})

$(".banner a").on("click", function(event) {
	$(".banner a").removeClass("border-b");
	$(event.target).addClass("border-b");
})

$(".user-action a").on("click", function(event) {
	$(".user-action a").removeClass("bg-gray");
	$(event.target).addClass("bg-gray");
})

function datetime(time) {
	var date = new Date(time);
	return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
			+ date.getDate() + " " + date.getHours() + ":" + date.getMinutes()
			+ ":" + date.getSeconds();
}
function deleteorderline(orderid,pcname)
{
	var orderid= orderid;
	var pcname = pcname;
	$.ajax({
		type : "post",
		url : "/customer/deletepc",
		dataType : "json",
		data : {
			orderid : orderid,
			pcname:pcname,
		},
		success : function(data) {
			console.log("成功", data);
			location.href = "toPage?url=e-commerce_order.html";
		},
		error : function(data) {
			console.log("失败", data);
		}
	})
}
function pay(id)
{
	sessionStorage.setItem("topay",id);
	location.href = "toPage?url=e-commerce_settlement.html";
}
