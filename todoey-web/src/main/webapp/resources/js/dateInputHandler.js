window.onload = () => {
	const elems = document.querySelectorAll('.datepicker');
	elems.forEach(elem => {
		elem.onchange = () => {
			const regex = /\d{2}\/\d{2}\/\d{4}/;
			if(regex.test(elem.value))
				elem.setCustomValidity('');
			else
				elem.setCustomValidity(
					window.navigator.language === 'pt-BR' 
						? 'Por favor insira a data no formato dd/mm/yyyy ou clique para escolher uma data'
						: 'Please insert date in format dd/mm/yyyy or click to pick a date'
				)
		}
	});
	const options = { format: 'dd/mm/yyyy' }
	M.Datepicker.init(elems, options);
};