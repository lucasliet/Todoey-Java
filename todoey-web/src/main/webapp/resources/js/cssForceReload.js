const getRootPath = () => window.location.pathname.split('/')[1];

function removeRnd(href) {
	const rndQueryPattern = /(&|\?)rnd=\d+/;
	return href.replace(rndQueryPattern, '');
}

function generateRandomQueryParam(rootPath) {
	document.querySelectorAll(`link[href^='/${rootPath}']`)
		.forEach(linkTag => {

			const href = removeRnd(linkTag.href);

			linkTag.href =
				`${href}${href.includes('?') ? '&' : '?'}rnd=${Date.now()}`;
		});
}

window.onload = () => generateRandomQueryParam(getRootPath());