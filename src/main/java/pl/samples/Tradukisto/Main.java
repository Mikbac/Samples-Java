package pl.samples.Tradukisto;

import lombok.extern.log4j.Log4j2;
import org.quartz.SchedulerException;
import pl.allegro.finance.tradukisto.MoneyConverters;
import pl.allegro.finance.tradukisto.ValueConverters;

import java.math.BigDecimal;

/**
 * Created by MikBac on 23.05.2022
 */

@Log4j2
public class Main {

    public static void main(String[] args) throws SchedulerException {
        getValueConverter();
        getMoneyConverter();

    }

    private static void getValueConverter() {
        ValueConverters englishConverter = ValueConverters.ENGLISH_INTEGER;
        String englishValueAsWords = englishConverter.asWords(777_77);
        // seventy-seven thousand seven hundred seventy-seven
        log.info(englishValueAsWords);

        ValueConverters germanConverter = ValueConverters.GERMAN_INTEGER;
        String germanValueAsWords = germanConverter.asWords(777_77);
        // siebenundsiebzigtausendsiebenhundertsiebenundsiebzig
        log.info(germanValueAsWords);
    }

    private static void getMoneyConverter() {
        MoneyConverters englishConverter = MoneyConverters.ENGLISH_BANKING_MONEY_VALUE;
        String englishValueAsWords = englishConverter.asWords(new BigDecimal("777.77"));
        // seven hundred seventy-seven ? 77/100
        log.info(englishValueAsWords);

        MoneyConverters germanConverter = MoneyConverters.GERMAN_BANKING_MONEY_VALUE;
        String germanValueAsWords = germanConverter.asWords(new BigDecimal("777.77"));
        // siebenhundertsiebenundsiebzig � 77/100
        log.info(germanValueAsWords);
    }
}
