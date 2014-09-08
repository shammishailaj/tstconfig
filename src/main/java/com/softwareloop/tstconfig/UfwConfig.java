package com.softwareloop.tstconfig;

import java.util.ArrayList;

/**
 * @author Paolo Predonzani (paolo.predonzani@gmail.com)
 */
public class UfwConfig extends Config {

    //--------------------------------------------------------------------------
    // Constants
    //--------------------------------------------------------------------------

    enum State {
        HEADER,
        RULES
    }

    //--------------------------------------------------------------------------
    // Fields
    //--------------------------------------------------------------------------

    State state;

    //--------------------------------------------------------------------------
    // Constructors
    //--------------------------------------------------------------------------

    public UfwConfig() {
        setParseMode(ParseMode.keyvalue);
        setKeySeparator(":");
        setSeparator(null);
        state = State.HEADER;
        sections.put("rules", new ArrayList<String[]>());
    }


    //--------------------------------------------------------------------------
    // AbstractKeyValueConfig implementation
    //--------------------------------------------------------------------------

    @Override
    public void parseBlankLine(String line) {
        if (state == State.HEADER) {
            setParseMode(ParseMode.fixed);
            setPositions(27, 39);
            state = State.RULES;
            currentSection = sections.get("rules");
        }
    }

    //--------------------------------------------------------------------------
    // Methods
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    // Abstract methods
    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------
    // Getters/setters
    //--------------------------------------------------------------------------

}
