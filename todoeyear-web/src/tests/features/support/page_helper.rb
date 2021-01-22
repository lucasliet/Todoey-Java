Dir[File.join(File.dirname(__FILE__), '../pages/*.rb')].each do |file|
  require file
end

module PageObjects

    def home_page
      @home_page ||= HomePage.new
    end

    def new_page
      @new_page ||= NewPage.new
    end

    def signup_page
      @signup_page ||= SignupPage.new
    end

    def login_page
      @login_page ||= LoginPage.new
    end
    
end