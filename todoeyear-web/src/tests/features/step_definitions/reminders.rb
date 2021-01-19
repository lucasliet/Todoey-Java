Quando('eu preencho os campos do formulário.') do
  new_page = NewPage.new
  new_page.load
  new_page.register_reminder 'Reminder Capybara', '29/01/2021', 'Lembrete inserido através da automação Capybara'
end

Então('eu checo se o lembrete foi registrado com sucesso.') do
  visit '/home.xhtml'
  page.has_text? 'Lembrete inserido através da automação Capybara'
end

Quando('eu clico em editar um lembrete.') do
  all('.col.s1.black-text.edit').last.click
end

Quando('Preencho os campos do formulário.') do
  fill_in id: 'reminder_body', with: 'Lembrete alterado através da automação Capybara'
  find('#save-button').click
end

Então('eu checo se os dados foram alterados com sucesso.') do
  page.has_text? 'Lembrete alterado através da automação Capybara'
end

Quando('eu clico em deletar um lembrete.') do
  page_home = HomePage.new
  page_home.load
  @total_reminders_before_delete = page_home.reminders_list.size
  all('.col.s1.black-text.delete').last.click
  @total_reminders_after_delete = page_home.reminders_list.size
end

Então('eu checo se o lembrete foi deletado com sucesso.') do
  expect(@total_reminders_after_delete).to eql @total_reminders_before_delete - 1
end
