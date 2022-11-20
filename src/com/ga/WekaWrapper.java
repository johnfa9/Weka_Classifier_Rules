package com.ga;

import weka.core.Attribute;
import weka.core.Capabilities;
import weka.core.Capabilities.Capability;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.RevisionUtils;
import weka.classifiers.Classifier;
import weka.classifiers.AbstractClassifier;

public class WekaWrapper
        extends AbstractClassifier {

    /**
     * Returns only the toString() method.
     *
     * @return a string describing the classifier
     */
    public String globalInfo() {
        return toString();
    }

    /**
     * Returns the capabilities of this classifier.
     *
     * @return the capabilities
     */
    public Capabilities getCapabilities() {
        weka.core.Capabilities result = new weka.core.Capabilities(this);

        result.enable(weka.core.Capabilities.Capability.NOMINAL_ATTRIBUTES);
        result.enable(weka.core.Capabilities.Capability.NUMERIC_ATTRIBUTES);
        result.enable(weka.core.Capabilities.Capability.DATE_ATTRIBUTES);
        result.enable(weka.core.Capabilities.Capability.MISSING_VALUES);
        result.enable(weka.core.Capabilities.Capability.NOMINAL_CLASS);
        result.enable(weka.core.Capabilities.Capability.MISSING_CLASS_VALUES);


        result.setMinimumNumberInstances(0);

        return result;
    }

    /**
     * only checks the data against its capabilities.
     *
     * @param i the training data
     */
    public void buildClassifier(Instances i) throws Exception {
        // can classifier handle the data?
        getCapabilities().testWithFail(i);
    }

    /**
     * Classifies the given instance.
     *
     * @param i the instance to classify
     * @return the classification result
     */
    public double classifyInstance(Instance i) throws Exception {
        Object[] s = new Object[i.numAttributes()];

        for (int j = 0; j < s.length; j++) {
            if (!i.isMissing(j)) {
                if (i.attribute(j).isNominal())
                    s[j] = new String(i.stringValue(j));
                else if (i.attribute(j).isNumeric())
                    s[j] = new Double(i.value(j));
            }
        }

        // set class value to missing
        s[i.classIndex()] = null;

        return WekaClassifier.classify(s);
    }

    /**
     * Returns the revision string.
     *
     * @return        the revision
     */
    public String getRevision() {
        return RevisionUtils.extract("1.0");
    }

    /**
     * Returns only the classnames and what classifier it is based on.
     *
     * @return a short description
     */
    public String toString() {
        return "Auto-generated classifier wrapper, based on weka.classifiers.trees.J48 (generated with Weka 3.8.6).\n" + this.getClass().getName() + "/WekaClassifier";
    }

    /**
     * Runs the classfier from commandline.
     *
     * @param args the commandline arguments
     */
    public static void main(String args[]) {
        runClassifier(new WekaWrapper(), args);
    }
}

class WekaClassifier {

    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaClassifier.N112af05f0(i);
        return p;
    }
    static double N112af05f0(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 4.0) {
            p = WekaClassifier.N6f587ef41(i);
        } else if (((Double) i[2]).doubleValue() > 4.0) {
            p = 1;
        }
        return p;
    }
    static double N6f587ef41(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= 3.0) {
            p = WekaClassifier.N4610f6172(i);
        } else if (((Double) i[3]).doubleValue() > 3.0) {
            p = WekaClassifier.N65da9ac114(i);
        }
        return p;
    }
    static double N4610f6172(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 0.0) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 0.0) {
            p = WekaClassifier.N2b66444d3(i);
        }
        return p;
    }
    static double N2b66444d3(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 3.0) {
            p = WekaClassifier.N6d88f1764(i);
        } else if (((Double) i[2]).doubleValue() > 3.0) {
            p = WekaClassifier.N7d82251910(i);
        }
        return p;
    }
    static double N6d88f1764(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (i[0].equals("Personal Travel")) {
            p = 0;
        } else if (i[0].equals("Business travel")) {
            p = WekaClassifier.N410b9ded5(i);
        }
        return p;
    }
    static double N410b9ded5(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 3.0) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 3.0) {
            p = WekaClassifier.Nea6b956(i);
        }
        return p;
    }
    static double Nea6b956(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (i[1].equals("Eco Plus")) {
            p = 0;
        } else if (i[1].equals("Business")) {
            p = WekaClassifier.N193713e97(i);
        } else if (i[1].equals("Eco")) {
            p = 0;
        }
        return p;
    }
    static double N193713e97(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= 2.0) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() > 2.0) {
            p = WekaClassifier.N339e52f88(i);
        }
        return p;
    }
    static double N339e52f88(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= 2.0) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() > 2.0) {
            p = WekaClassifier.N2ee755939(i);
        }
        return p;
    }
    static double N2ee755939(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 2.0) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 2.0) {
            p = 0;
        }
        return p;
    }
    static double N7d82251910(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (i[0].equals("Personal Travel")) {
            p = 0;
        } else if (i[0].equals("Business travel")) {
            p = WekaClassifier.N5c8bc91b11(i);
        }
        return p;
    }
    static double N5c8bc91b11(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 4.0) {
            p = WekaClassifier.N1dc359e012(i);
        } else if (((Double) i[4]).doubleValue() > 4.0) {
            p = 1;
        }
        return p;
    }
    static double N1dc359e012(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= 2.0) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() > 2.0) {
            p = WekaClassifier.N99cdc0613(i);
        }
        return p;
    }
    static double N99cdc0613(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 3.0) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > 3.0) {
            p = 0;
        }
        return p;
    }
    static double N65da9ac114(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (i[0].equals("Personal Travel")) {
            p = 0;
        } else if (i[0].equals("Business travel")) {
            p = WekaClassifier.N671b547015(i);
        }
        return p;
    }
    static double N671b547015(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= 2.0) {
            p = WekaClassifier.N60101d2a16(i);
        } else if (((Double) i[5]).doubleValue() > 2.0) {
            p = WekaClassifier.N63a2d11220(i);
        }
        return p;
    }
    static double N60101d2a16(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= 4.0) {
            p = WekaClassifier.Nf8391c217(i);
        } else if (((Double) i[3]).doubleValue() > 4.0) {
            p = 1;
        }
        return p;
    }
    static double Nf8391c217(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 3.0) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 3.0) {
            p = WekaClassifier.N3ebe0e6118(i);
        }
        return p;
    }
    static double N3ebe0e6118(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 2.0) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 2.0) {
            p = WekaClassifier.N33b651219(i);
        }
        return p;
    }
    static double N33b651219(Object []i) {
        double p = Double.NaN;
        if (i[6] == null) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() <= 5.0) {
            p = 1;
        } else if (((Double) i[6]).doubleValue() > 5.0) {
            p = 0;
        }
        return p;
    }
    static double N63a2d11220(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (i[1].equals("Eco Plus")) {
            p = 1;
        } else if (i[1].equals("Business")) {
            p = WekaClassifier.N70bc512521(i);
        } else if (i[1].equals("Eco")) {
            p = WekaClassifier.N64977cb27(i);
        }
        return p;
    }
    static double N70bc512521(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 3.0) {
            p = WekaClassifier.N3ebf945522(i);
        } else if (((Double) i[4]).doubleValue() > 3.0) {
            p = 1;
        }
        return p;
    }
    static double N3ebf945522(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= 4.0) {
            p = WekaClassifier.N6674656523(i);
        } else if (((Double) i[3]).doubleValue() > 4.0) {
            p = 1;
        }
        return p;
    }
    static double N6674656523(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= 4.0) {
            p = WekaClassifier.N132b02f824(i);
        } else if (((Double) i[5]).doubleValue() > 4.0) {
            p = 1;
        }
        return p;
    }
    static double N132b02f824(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 3.0) {
            p = WekaClassifier.N18c4cc125(i);
        } else if (((Double) i[2]).doubleValue() > 3.0) {
            p = 1;
        }
        return p;
    }
    static double N18c4cc125(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 1.0) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 1.0) {
            p = WekaClassifier.N43d37d9926(i);
        }
        return p;
    }
    static double N43d37d9926(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 2.0) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 2.0) {
            p = 1;
        }
        return p;
    }
    static double N64977cb27(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 3.0) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > 3.0) {
            p = WekaClassifier.N4d3e893828(i);
        }
        return p;
    }
    static double N4d3e893828(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 3.0) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 3.0) {
            p = 1;
        }
        return p;
    }
}


