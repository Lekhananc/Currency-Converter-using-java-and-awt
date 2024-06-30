public class Currency {

    public double convert(String fromCurrencyValue,String toCurrencyValue,double value) {
        double convertedCurrencyValue = 0;
        if (fromCurrencyValue.equals(toCurrencyValue)) {
            convertedCurrencyValue = value;
        }


        else if (fromCurrencyValue.equals("INR") && toCurrencyValue.equals("USD")) {
            convertedCurrencyValue = value * 0.012;
        } else if (fromCurrencyValue.equals("INR") && toCurrencyValue.equals("EUR")) {
            convertedCurrencyValue = value * 0.011;
        } else if (fromCurrencyValue.equals("INR") && toCurrencyValue.equals("JPY")) {
            convertedCurrencyValue = value * 1.93;
        }


        else if (fromCurrencyValue.equals("USD") && toCurrencyValue.equals("INR")) {
            convertedCurrencyValue = value * 83.36;
        } else if (fromCurrencyValue.equals("USD") && toCurrencyValue.equals("EUR")) {
            convertedCurrencyValue = value * 0.93;
        } else if (fromCurrencyValue.equals("USD") && toCurrencyValue.equals("JPY")) {
            convertedCurrencyValue = value * 160.89;
        }


        else if (fromCurrencyValue.equals("EUR") && toCurrencyValue.equals("INR")) {
            convertedCurrencyValue = value * 89.33;
        } else if (fromCurrencyValue.equals("EUR") && toCurrencyValue.equals("USD")) {
            convertedCurrencyValue = value * 1.07;
        } else if (fromCurrencyValue.equals("EUR") && toCurrencyValue.equals("JPY")) {
            convertedCurrencyValue = value * 172.50;
        }


        else if (fromCurrencyValue.equals("JPY") && toCurrencyValue.equals("INR")) {
            convertedCurrencyValue = value * 0.52;
        } else if (fromCurrencyValue.equals("JPY") && toCurrencyValue.equals("USD")) {
            convertedCurrencyValue = value * 0.0062;
        } else if (fromCurrencyValue.equals("JPY") && toCurrencyValue.equals("EUR")) {
            convertedCurrencyValue = value * 0.0058;
        }

        return convertedCurrencyValue;
    }
}
