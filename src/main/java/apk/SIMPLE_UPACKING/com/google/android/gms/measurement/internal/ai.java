package com.google.android.gms.measurement.internal;

import android.support.v4.p014g.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.p051b.la;
import com.google.android.gms.p051b.lb;
import com.google.android.gms.p051b.lc;
import com.google.android.gms.p051b.le;
import com.google.android.gms.p051b.lm;
import com.google.android.gms.p051b.ln;
import com.google.android.gms.p051b.lo;
import com.google.android.gms.p051b.lr;
import com.google.android.gms.p051b.ls;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

class ai extends cl {
    ai(bx bxVar) {
        super(bxVar);
    }

    private Boolean m8312a(lb lbVar, ln lnVar, long j) {
        Boolean a;
        if (lbVar.f3900e != null) {
            a = new bm(lbVar.f3900e).m8644a(j);
            if (a == null) {
                return null;
            }
            if (!a.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (lc lcVar : lbVar.f3898c) {
            if (TextUtils.isEmpty(lcVar.f3905d)) {
                m8220s().m8583c().m8608a("null or empty param name in filter. event", lnVar.f3938b);
                return null;
            }
            hashSet.add(lcVar.f3905d);
        }
        Map arrayMap = new ArrayMap();
        for (lo loVar : lnVar.f3937a) {
            if (hashSet.contains(loVar.f3943a)) {
                if (loVar.f3945c != null) {
                    arrayMap.put(loVar.f3943a, loVar.f3945c);
                } else if (loVar.f3946d != null) {
                    arrayMap.put(loVar.f3943a, loVar.f3946d);
                } else if (loVar.f3944b != null) {
                    arrayMap.put(loVar.f3943a, loVar.f3944b);
                } else {
                    m8220s().m8583c().m8609a("Unknown value for param. event, param", lnVar.f3938b, loVar.f3943a);
                    return null;
                }
            }
        }
        for (lc lcVar2 : lbVar.f3898c) {
            CharSequence charSequence = lcVar2.f3905d;
            if (TextUtils.isEmpty(charSequence)) {
                m8220s().m8583c().m8608a("Event has empty param name. event", lnVar.f3938b);
                return null;
            }
            Object obj = arrayMap.get(charSequence);
            if (obj instanceof Long) {
                if (lcVar2.f3903b == null) {
                    m8220s().m8583c().m8609a("No number filter for long param. event, param", lnVar.f3938b, charSequence);
                    return null;
                }
                a = new bm(lcVar2.f3903b).m8644a(((Long) obj).longValue());
                if (a == null) {
                    return null;
                }
                if (!a.booleanValue()) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Float) {
                if (lcVar2.f3903b == null) {
                    m8220s().m8583c().m8609a("No number filter for float param. event, param", lnVar.f3938b, charSequence);
                    return null;
                }
                a = new bm(lcVar2.f3903b).m8643a(((Float) obj).floatValue());
                if (a == null) {
                    return null;
                }
                if (!a.booleanValue()) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (lcVar2.f3902a == null) {
                    m8220s().m8583c().m8609a("No string filter for String param. event, param", lnVar.f3938b, charSequence);
                    return null;
                }
                a = new ab(lcVar2.f3902a).m8201a((String) obj);
                if (a == null) {
                    return null;
                }
                if (!a.booleanValue()) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                m8220s().m8606z().m8609a("Missing param for filter. event, param", lnVar.f3938b, charSequence);
                return Boolean.valueOf(false);
            } else {
                m8220s().m8583c().m8609a("Unknown param type. event, param", lnVar.f3938b, charSequence);
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private Boolean m8313a(le leVar, ls lsVar) {
        Boolean bool = null;
        lc lcVar = leVar.f3914c;
        if (lcVar == null) {
            m8220s().m8583c().m8608a("Missing property filter. property", lsVar.f3980b);
            return bool;
        } else if (lsVar.f3982d != null) {
            if (lcVar.f3903b != null) {
                return new bm(lcVar.f3903b).m8644a(lsVar.f3982d.longValue());
            }
            m8220s().m8583c().m8608a("No number filter for long property. property", lsVar.f3980b);
            return bool;
        } else if (lsVar.f3983e != null) {
            if (lcVar.f3903b != null) {
                return new bm(lcVar.f3903b).m8643a(lsVar.f3983e.floatValue());
            }
            m8220s().m8583c().m8608a("No number filter for float property. property", lsVar.f3980b);
            return bool;
        } else if (lsVar.f3981c == null) {
            m8220s().m8583c().m8608a("User property has no value, property", lsVar.f3980b);
            return bool;
        } else if (lcVar.f3902a != null) {
            return new ab(lcVar.f3902a).m8201a(lsVar.f3981c);
        } else {
            if (lcVar.f3903b == null) {
                m8220s().m8583c().m8608a("No string or number filter defined. property", lsVar.f3980b);
                return bool;
            }
            bm bmVar = new bm(lcVar.f3903b);
            if (lcVar.f3903b.f3907b.booleanValue()) {
                if (m8318b(lsVar.f3981c)) {
                    try {
                        float parseFloat = Float.parseFloat(lsVar.f3981c);
                        if (!Float.isInfinite(parseFloat)) {
                            return bmVar.m8643a(parseFloat);
                        }
                        m8220s().m8583c().m8609a("User property value exceeded Float value range. property, value", lsVar.f3980b, lsVar.f3981c);
                        return bool;
                    } catch (NumberFormatException e) {
                        m8220s().m8583c().m8609a("User property value exceeded Float value range. property, value", lsVar.f3980b, lsVar.f3981c);
                        return bool;
                    }
                }
                m8220s().m8583c().m8609a("Invalid user property value for Float number filter. property, value", lsVar.f3980b, lsVar.f3981c);
                return bool;
            } else if (m8316a(lsVar.f3981c)) {
                try {
                    return bmVar.m8644a(Long.parseLong(lsVar.f3981c));
                } catch (NumberFormatException e2) {
                    m8220s().m8583c().m8609a("User property value exceeded Long value range. property, value", lsVar.f3980b, lsVar.f3981c);
                    return bool;
                }
            } else {
                m8220s().m8583c().m8609a("Invalid user property value for Long number filter. property, value", lsVar.f3980b, lsVar.f3981c);
                return bool;
            }
        }
    }

    protected void m8314a() {
    }

    void m8315a(String str, la[] laVarArr) {
        m8215n().m8408a(str, laVarArr);
    }

    boolean m8316a(String str) {
        return Pattern.matches("[+-]?[0-9]+", str);
    }

    lm[] m8317a(String str, ln[] lnVarArr, ls[] lsVarArr) {
        int intValue;
        Map map;
        Map map2;
        lm lmVar;
        lm lmVar2;
        BitSet bitSet;
        BitSet bitSet2;
        int i;
        bf.m7875a(str);
        Set hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        Map arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (lnVarArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            for (ln lnVar : lnVarArr) {
                as asVar;
                as a = m8215n().m8394a(str, lnVar.f3938b);
                if (a == null) {
                    m8220s().m8583c().m8608a("Event aggregate wasn't created during raw event logging. event", lnVar.f3938b);
                    asVar = new as(str, lnVar.f3938b, 1, 1, lnVar.f3939c.longValue());
                } else {
                    asVar = a.m8472a();
                }
                m8215n().m8402a(asVar);
                long j = asVar.f4688c;
                map = (Map) arrayMap4.get(lnVar.f3938b);
                if (map == null) {
                    map = m8215n().m8422d(str, lnVar.f3938b);
                    if (map == null) {
                        map = new ArrayMap();
                    }
                    arrayMap4.put(lnVar.f3938b, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                m8220s().m8606z().m8609a("Found audiences. event, audience count", lnVar.f3938b, Integer.valueOf(map2.size()));
                for (Integer intValue2 : map2.keySet()) {
                    int intValue3 = intValue2.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        m8220s().m8606z().m8608a("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        lmVar = (lm) arrayMap.get(Integer.valueOf(intValue3));
                        if (lmVar == null) {
                            lmVar = new lm();
                            arrayMap.put(Integer.valueOf(intValue3), lmVar);
                            lmVar.f3935d = Boolean.valueOf(false);
                            lmVar2 = lmVar;
                        } else {
                            lmVar2 = lmVar;
                        }
                        List<lb> list = (List) map2.get(Integer.valueOf(intValue3));
                        bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue3));
                        if (bitSet == null) {
                            bitSet = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue3), bitSet);
                            bitSet2 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue3), bitSet2);
                        }
                        if (lmVar2.f3934c == null && !lmVar2.f3935d.booleanValue()) {
                            lr c = m8215n().m8419c(str, intValue3);
                            if (c != null) {
                                lmVar2.f3934c = c;
                                i = 0;
                                while (true) {
                                    if (i >= c.f3977b.length * 64) {
                                        break;
                                    }
                                    if (ag.m8268a(c.f3977b, i)) {
                                        m8220s().m8606z().m8609a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), Integer.valueOf(i));
                                        bitSet.set(i);
                                        bitSet2.set(i);
                                    }
                                    i++;
                                }
                            } else {
                                lmVar2.f3935d = Boolean.valueOf(true);
                            }
                        }
                        for (lb lbVar : list) {
                            if (m8220s().m8581a(2)) {
                                m8220s().m8606z().m8610a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), lbVar.f3896a, lbVar.f3897b);
                                m8220s().m8606z().m8608a("Filter definition", lbVar);
                            }
                            if (lbVar.f3896a.intValue() > 256) {
                                m8220s().m8583c().m8608a("Invalid event filter ID > 256. id", lbVar.f3896a);
                            } else if (!bitSet2.get(lbVar.f3896a.intValue())) {
                                Boolean a2 = m8312a(lbVar, lnVar, j);
                                m8220s().m8606z().m8608a("Event filter result", a2);
                                if (a2 == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet2.set(lbVar.f3896a.intValue());
                                    if (a2.booleanValue()) {
                                        bitSet.set(lbVar.f3896a.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (lsVarArr != null) {
            Map arrayMap5 = new ArrayMap();
            for (ls lsVar : lsVarArr) {
                map = (Map) arrayMap5.get(lsVar.f3980b);
                if (map == null) {
                    map = m8215n().m8424e(str, lsVar.f3980b);
                    if (map == null) {
                        map = new ArrayMap();
                    }
                    arrayMap5.put(lsVar.f3980b, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                m8220s().m8606z().m8609a("Found audiences. property, audience count", lsVar.f3980b, Integer.valueOf(map2.size()));
                for (Integer intValue22 : map2.keySet()) {
                    intValue = intValue22.intValue();
                    if (!hashSet.contains(Integer.valueOf(intValue))) {
                        lmVar = (lm) arrayMap.get(Integer.valueOf(intValue));
                        if (lmVar == null) {
                            lmVar = new lm();
                            arrayMap.put(Integer.valueOf(intValue), lmVar);
                            lmVar.f3935d = Boolean.valueOf(false);
                            lmVar2 = lmVar;
                        } else {
                            lmVar2 = lmVar;
                        }
                        List<le> list2 = (List) map2.get(Integer.valueOf(intValue));
                        bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue));
                        bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue));
                        if (bitSet == null) {
                            bitSet = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue), bitSet);
                            bitSet2 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue), bitSet2);
                        }
                        if (lmVar2.f3934c == null) {
                            if (!lmVar2.f3935d.booleanValue()) {
                                lr c2 = m8215n().m8419c(str, intValue);
                                if (c2 != null) {
                                    lmVar2.f3934c = c2;
                                    i = 0;
                                    while (true) {
                                        if (i >= c2.f3977b.length * 64) {
                                            break;
                                        }
                                        if (ag.m8268a(c2.f3977b, i)) {
                                            bitSet.set(i);
                                            bitSet2.set(i);
                                        }
                                        i++;
                                    }
                                } else {
                                    lmVar2.f3935d = Boolean.valueOf(true);
                                }
                            }
                        }
                        for (le leVar : list2) {
                            if (m8220s().m8581a(2)) {
                                m8220s().m8606z().m8610a("Evaluating filter. audience, filter, property", Integer.valueOf(intValue), leVar.f3912a, leVar.f3913b);
                                m8220s().m8606z().m8608a("Filter definition", leVar);
                            }
                            if (leVar.f3912a != null) {
                                if (leVar.f3912a.intValue() <= 256) {
                                    if (bitSet2.get(leVar.f3912a.intValue())) {
                                        m8220s().m8606z().m8609a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue), leVar.f3912a);
                                    } else {
                                        Boolean a3 = m8313a(leVar, lsVar);
                                        m8220s().m8606z().m8608a("Property filter result", a3);
                                        if (a3 == null) {
                                            hashSet.add(Integer.valueOf(intValue));
                                        } else {
                                            bitSet2.set(leVar.f3912a.intValue());
                                            if (a3.booleanValue()) {
                                                bitSet.set(leVar.f3912a.intValue());
                                            }
                                        }
                                    }
                                }
                            }
                            m8220s().m8583c().m8608a("Invalid property filter ID. id", String.valueOf(leVar.f3912a));
                            hashSet.add(Integer.valueOf(intValue));
                            break;
                        }
                    }
                    m8220s().m8606z().m8608a("Skipping failed audience ID", Integer.valueOf(intValue));
                }
            }
        }
        lm[] lmVarArr = new lm[arrayMap2.size()];
        int i2 = 0;
        for (Integer intValue222 : arrayMap2.keySet()) {
            int intValue4 = intValue222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue4))) {
                lmVar = (lm) arrayMap.get(Integer.valueOf(intValue4));
                lm lmVar3 = lmVar == null ? new lm() : lmVar;
                int i3 = i2 + 1;
                lmVarArr[i2] = lmVar3;
                lmVar3.f3932a = Integer.valueOf(intValue4);
                lmVar3.f3933b = new lr();
                lmVar3.f3933b.f3977b = ag.m8269a((BitSet) arrayMap2.get(Integer.valueOf(intValue4)));
                lmVar3.f3933b.f3976a = ag.m8269a((BitSet) arrayMap3.get(Integer.valueOf(intValue4)));
                m8215n().m8405a(str, intValue4, lmVar3.f3933b);
                i2 = i3;
            }
        }
        return (lm[]) Arrays.copyOf(lmVarArr, i2);
    }

    boolean m8318b(String str) {
        return Pattern.matches("[+-]?(([0-9]+\\.?)|([0-9]*\\.[0-9]+))", str);
    }
}
