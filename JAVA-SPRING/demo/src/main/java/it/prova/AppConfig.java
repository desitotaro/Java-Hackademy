package it.prova;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.prova.model.Batman;
import it.prova.model.Batmobile;
import it.prova.model.Mask;
import it.prova.model.Hook;
import it.prova.model.Suit;

@ComponentScan("it.prova")
@Configuration
public class AppConfig {
    @Bean(name="batman")
    public Batman getBatman()
    {
        return new Batman(getSuit(), getBatmobile());
    }

    @Bean(name = "batmobile")
    public Batmobile getBatmobile()
    {
        return new Batmobile("colore");
    }

    @Bean(name = "mask")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Mask getMask()
    {
        return new Mask("colore");
    }

    @Bean(name = "hook")
    public Hook getHook()
    {
        return new Hook(10);
    }

    @Bean(name = "suit")
    public Suit getSuit()
    {
        return new Suit("colore", getMask(), getHook());
    }
}
