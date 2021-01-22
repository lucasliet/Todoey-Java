function loadEditPage(reminderId){
	let { origin, pathname } = window.location;
	
	const context_url = pathname.split('/')[1];
	
	const anchor = 'new.xhtml?reminderId=' + reminderId;
	
	window.location.href = origin + '/' + context_url + '/' + anchor;
}