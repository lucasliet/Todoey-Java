document.addEventListener('DOMContentLoaded', function() {
	const elems = document.querySelectorAll('.datepicker');
	elems.forEach(elem => {
		elem.onchange = () => {
			const regex = /\d{2}\/\d{2}\/\d{4}/;
			if(regex.test(elem.value))
				elem.setCustomValidity('');
			else
				elem.setCustomValidity(
					'Please insert date in format dd/mm/yyyy or click to pick a date'
				)
		}
	});
	const options = { format: 'dd/mm/yyyy' }
	const instances = M.Datepicker.init(elems, options);
});

