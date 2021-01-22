function loadEditPage(reminderId){
	const { origin, pathname } = window.location;
	
	const rootPath = pathname.split('/')[1];
	
	const pageLink = `new.xhtml?reminderId=${reminderId}`;
	
	window.location.href = `${origin}/${rootPath}/${pageLink}`;
}