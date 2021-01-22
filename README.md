<h1 align="center">
  <img src="https://raw.githubusercontent.com/lucasliet/Todoey/main/.github/Title.svg">
</h1>
<p align="center">
  <img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/lucasliet/Todoey-Java">
  <img alt="GitHub" src="https://img.shields.io/github/license/lucasliet/Todoey-Java?color=red">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/lucasliet/Todoey-Java">
  <br/><br/><br/>
</p>

# 📰️ Índice
- [Como utilizar](#%EF%B8%8F-como-utilizar)
- [Sobre](#%EF%B8%8F-sobre)
- [Tecnologias Utilizadas](#%EF%B8%8F-tecnologias-utilizadas)
- [Preview](#%EF%B8%8F-preview)
- [Para baixar e reproduzir o projeto](#%EF%B8%8F-para-baixar-e-reproduzir-o-projeto)
- [Para executar os testes](#-para-executar-os-testes)
- [Como contribuir](#%EF%B8%8F-como-contribuir)
- [Licença](#-licença)
# 📚️ Sobre

Todoey é um app de cadastro de lembretes feito em JavaEE com REST e SOAP

# 👨‍💻️ Tecnologias Utilizadas

Alguns destaques nas tecnologias utilizadas neste projeto são:

- [Maven](http://maven.apache.org/)
- [Eclipse](https://www.eclipse.org/)
- [WildFly](https://www.wildfly.org/)
- [Java Server Faces](https://www.oracle.com/java/technologies/javaserverfaces.html/)
- [Hibernate](https://hibernate.org/)
- [PostgresSQL](https://www.postgresql.org/)
- [Resteasy](https://resteasy.github.io/)
- [Insomnia](https://insomnia.rest/)
- [SoapUI](https://www.soapui.org/)
- [Capybara](http://teamcapybara.github.io/capybara/)
# 🔎️ Preview
> O mockup utilizado para o projeto está disponivel no [Figma](https://www.figma.com/file/GPWIRTijJmWMIQcXSYXNUO/Todoey?node-id=0%3A1)

# ⚙️ Para baixar e reproduzir o projeto

- ### **Pré-requisitos**
  
  - É necessário ter instalado o git, caso esteja no Windows, baixe o [instalador](https://git-scm.com/download/win),no Ubuntu e derivados pode ser instalado com
  ```
  # apt install git -y
  ```
  - A forma mais fácil é ter o [Eclipse] instalado, pois ele já possui o **[Maven](http://maven.apache.org/)** e um gerenciador de servidores compativel com o wildfly
  - **[Java 11 ou +](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)** instalado
  - **[WildFly 22](https://download.jboss.org/wildfly/22.0.0.Final/wildfly-22.0.0.Final.zip)**
  - **[PostgresSQL](https://www.postgresql.org/)** ou outro banco de dados de preferência
  
  após baixar e extrair o WildFly, deverá configura-lo para funcionar com o banco de dados
  caso tenha escolhido utiliza-lo com postgres, pode encontrar um tutorial de configuração [aqui](https://www.notion.so/Wildfly-209da9accbcc4e8c938eaaf237679d9a) (o tutorial é para a versão 20, mas as configurações são as mesmas na versão 22)

1. **Faça um clone:**

```sh
  $ git clone https://github.com/lucasliet/Todoey-Java.git
```

2. **Importe o projeto no Eclipse como Maven Project**

3. **Clique com botão direto no servidor WildFly configurado no Eclipse > em add > e adicione o projeto**

4. **Clique com botão direito novamente no servidor e em start**


# 🤖 Para executar os testes
- installe o [Firefox](https://www.mozilla.org/en-US/firefox/download/thanks/) ou o [Google Chrome](https://www.google.com/chrome/)
- caso tenha optado por `Firefox`, baixe o [geckodriver](https://github.com/mozilla/geckodriver/releases/latest), caso `Chrome`, baixe [chromedriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) e os mova o binário para o `PATH` do seu sistema
- teste-os se estão sendo executados corretamente, digite `geckodriver` ou `chromedriver` no seu terminal segido da flag `--version`
- instale o `Ruby` na versão 2.7.2, recomendo a utilização do [rbenv](https://github.com/rbenv/rbenv) para isso
- execute o comando
```sh
  $ gem install bundler
```
- navegue até a pasta de testes
```sh
  $ cd todoey-web/src/tests
```
- instale as dependencias
```sh
  $ bundle install
```
- **execute**
```sh
  $ cucumber
```

- ### Para testes dos WebServices

  > **Pode testar as rotas atráves das nossas rotas pré configuradas:**

  - REST: Insomnia

    [![Run in Insomnia}](https://insomnia.rest/images/run.svg)](InsomniaV4.json)
  - SOAP: SoapUI 
  
    [Projeto SoapUI](Todoey-Java-soapui-project.xml)

# 🤝️ Como contribuir

- Faça um Fork desse repositório,
- Crie uma branch com a sua feature: `git checkout -b my-feature`
- Faça um commit com suas mudanças: `git commit -m 'feat: My new feature'`
- Faça um push da sua branch: `git push origin my-feature`
- Abra um Pull Request no github explicando suas mudanças e o motivo para elas

# 👮 Licença

Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

<hr/>
<h4 align="center">
    Feito com ❤️ por <a href="https://www.linkedin.com/in/lucas-souza-de-oliveira/" target="_blank">Lucas Souza</a>
</h4>
