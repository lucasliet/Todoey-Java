
Quando('eu digito usuário ou senha inválidos.') do
  login_page.load
  login_page.login 'user@notfound.com', '123'
end

Então('espero a mensagem de usuário não encontrado.') do
  expect(login_page.error_messages.text).to eql 'USER NOT FOUND'
end

Quando('eu tento cadastrar e-mail já existente no sistema.') do
  signup_page.load
  signup_page.cadastrar 'lucasliet@test.com', '123'
end

Então('espero a mensagem de que o e-mail já existe.') do
  expect(signup_page.error_messages.text).to eql 'THIS USER E-MAIL ALREADY EXISTS'
end

Quando('eu tento inserir um lembrete com formato de data inválido.') do
  new_page.load
  new_page.register_reminder 'Reminder Capybara', 'Data inválida', 'Lembrete inserido através da automação Capybara'
end

Então('checo a mensagem de formato de data inválido.') do
  expect(new_page.error_messages.text).to eql 'INVALID DATE FORMAT! USE DD/MM/YYYY PATTERN'
end