Quando('eu preencho os campos do formulário.') do
  visit 'http://localhost:8080/todoeyear-web/login.xhtml'
  sleep 5
  fill_in id: 'email', with: 'lucasliet@test.com'
  fill_in id: 'senha', with: '123'
  find('#login').click
end

Então('eu checo se o lembrete foi registrado com sucesso.') do
  pending # Write code here that turns the phrase above into concrete actions
end

Quando('eu clico em editar um lembrete.') do
  pending # Write code here that turns the phrase above into concrete actions
end

Quando('Preencho os campos do formulário.') do
  pending # Write code here that turns the phrase above into concrete actions
end

Então('eu checo se os dados foram alterados com sucesso.') do
  pending # Write code here that turns the phrase above into concrete actions
end

Quando('eu clico em deletar um lembrete.') do
  pending # Write code here that turns the phrase above into concrete actions
end

Então('eu checo se o lembrete foi deletado com sucesso.') do
  pending # Write code here that turns the phrase above into concrete actions
end
