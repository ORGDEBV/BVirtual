$(function(){
	$(".w-maestrias .item .det ").each(function(){
		$(this).click(function(){
			$(".w-maestrias .item").removeClass("explain");
			$(this).parent().addClass("explain");
			$('#moEfect').masonry( 'reload' );
		});
	});

	 $(".w-maestrias .item .close").each(function(){
		$(this).click(function(e){
			e.preventDefault();
			$(this).parent().parent().removeClass("explain");
			$('#moEfect').masonry( 'reload' );
		});
	});

	if($.fn.masonry){
		$('#moEfect').masonry({
			itemSelector: '.item',
			isAnimated: true,
			columnWidth: 10,
			// gutterWidth: 20,
		});
	}
});
