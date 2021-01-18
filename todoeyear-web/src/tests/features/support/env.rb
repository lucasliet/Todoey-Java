# require 'capybara/cucumber'
require 'capybara'
require 'capybara/dsl'
require 'capybara/rspec/matchers'

require 'selenium-webdriver'
require 'site_prism'
require_relative 'page_helper.rb'

World(Capybara::DSL)
World(Capybara::RSpecMatchers)
World(PageObjects)

BROWSER = ENV['BROWSER']
AMBIENTE = ENV['AMBIENTE']
CONFIG = YAML.load_file(File.dirname(__FILE__) + "/ambientes/#{AMBIENTE}.yml")


Capybara.register_driver :selenium do |app|

  if BROWSER.eql?('poltergeist')
    options = { js_errors: false }
    Capybara::Poltergeist::Driver.new(app, options)
  elsif BROWSER.eql?('chrome_headless')
    Capybara::Selenium::Driver.new(app, :browser => :chrome,
    desired_capabilities: Selenium::WebDriver::Remote::Capabilities.chrome(
      'chromeOptions' => {'args' => ['--headless', 'disable-gpu']}
    ))
  elsif BROWSER.eql?('firefox_headless')
    browser_options = Selenium::WebDriver::Firefox::Options.new(args: ['--headless'])
    Capybara::Selenium::Driver.new(app, :browser => :firefox, options: browser_options)
  else
    Capybara::Selenium::Driver.new(app, :browser => BROWSER.to_sym)
  end

end

Capybara.configure do |config|
  # selenium (Firefox) selenium_chrome selenium_chrome_headless (NOGPU)
  config.default_driver = :selenium
  config.app_host = CONFIG['app_host']
  config.default_max_wait_time = 5
end