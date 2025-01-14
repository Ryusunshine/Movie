/*! modernizr 3.3.1 (Custom Build) | MIT *
 * https://modernizr.com/download/?-atobbtoa-backgroundsize-bgsizecover-boxshadow-boxsizing-classlist-cookies-cssgradients-displaytable-inputtypes-json-nthchild-queryselector-svg-touchevents-setclasses !*/
!function (e, t, n) {
    function i(e, t) {
        return typeof e === t
    }

    function o() {
        var e, t, n, o, r, s, a;
        for (var l in b) if (b.hasOwnProperty(l)) {
            if (e = [], t = b[l], t.name && (e.push(t.name.toLowerCase()), t.options && t.options.aliases && t.options.aliases.length)) for (n = 0; n < t.options.aliases.length; n++) e.push(t.options.aliases[n].toLowerCase());
            for (o = i(t.fn, "function") ? t.fn() : t.fn, r = 0; r < e.length; r++) s = e[r], a = s.split("."), 1 === a.length ? Modernizr[a[0]] = o : (!Modernizr[a[0]] || Modernizr[a[0]] instanceof Boolean || (Modernizr[a[0]] = new Boolean(Modernizr[a[0]])), Modernizr[a[0]][a[1]] = o), y.push((o ? "" : "no-") + a.join("-"))
        }
    }

    function r(e) {
        var t = w.className, n = Modernizr._config.classPrefix || "";
        if (S && (t = t.baseVal), Modernizr._config.enableJSClass) {
            var i = new RegExp("(^|\\s)" + n + "no-js(\\s|$)");
            t = t.replace(i, "$1" + n + "js$2")
        }
        Modernizr._config.enableClasses && (t += " " + n + e.join(" " + n), S ? w.className.baseVal = t : w.className = t)
    }

    function s() {
        return "function" != typeof t.createElement ? t.createElement(arguments[0]) : S ? t.createElementNS.call(t, "http://www.w3.org/2000/svg", arguments[0]) : t.createElement.apply(t, arguments)
    }

    function a() {
        var e = t.body;
        return e || (e = s(S ? "svg" : "body"), e.fake = !0), e
    }

    function l(e, n, i, o) {
        var r, l, d, f, u = "modernizr", c = s("div"), p = a();
        if (parseInt(i, 10)) for (; i--;) d = s("div"), d.id = o ? o[i] : u + (i + 1), c.appendChild(d);
        return r = s("style"), r.type = "text/css", r.id = "s" + u, (p.fake ? p : c).appendChild(r), p.appendChild(c), r.styleSheet ? r.styleSheet.cssText = e : r.appendChild(t.createTextNode(e)), c.id = u, p.fake && (p.style.background = "", p.style.overflow = "hidden", f = w.style.overflow, w.style.overflow = "hidden", w.appendChild(p)), l = n(c, e), p.fake ? (p.parentNode.removeChild(p), w.style.overflow = f, w.offsetHeight) : c.parentNode.removeChild(c), !!l
    }

    function d(e, t) {
        return !!~("" + e).indexOf(t)
    }

    function f(e) {
        return e.replace(/([a-z])-([a-z])/g, function (e, t, n) {
            return t + n.toUpperCase()
        }).replace(/^-/, "")
    }

    function u(e, t) {
        return function () {
            return e.apply(t, arguments)
        }
    }

    function c(e, t, n) {
        var o;
        for (var r in e) if (e[r] in t) return n === !1 ? e[r] : (o = t[e[r]], i(o, "function") ? u(o, n || t) : o);
        return !1
    }

    function p(e) {
        return e.replace(/([A-Z])/g, function (e, t) {
            return "-" + t.toLowerCase()
        }).replace(/^ms-/, "-ms-")
    }

    function m(t, i) {
        var o = t.length;
        if ("CSS" in e && "supports" in e.CSS) {
            for (; o--;) if (e.CSS.supports(p(t[o]), i)) return !0;
            return !1
        }
        if ("CSSSupportsRule" in e) {
            for (var r = []; o--;) r.push("(" + p(t[o]) + ":" + i + ")");
            return r = r.join(" or "), l("@supports (" + r + ") { #modernizr { position: absolute; } }", function (e) {
                return "absolute" == getComputedStyle(e, null).position
            })
        }
        return n
    }

    function h(e, t, o, r) {
        function a() {
            u && (delete A.style, delete A.modElem)
        }

        if (r = i(r, "undefined") ? !1 : r, !i(o, "undefined")) {
            var l = m(e, o);
            if (!i(l, "undefined")) return l
        }
        for (var u, c, p, h, g, v = ["modernizr", "tspan", "samp"]; !A.style && v.length;) u = !0, A.modElem = s(v.shift()), A.style = A.modElem.style;
        for (p = e.length, c = 0; p > c; c++) if (h = e[c], g = A.style[h], d(h, "-") && (h = f(h)), A.style[h] !== n) {
            if (r || i(o, "undefined")) return a(), "pfx" == t ? h : !0;
            try {
                A.style[h] = o
            } catch (y) {
            }
            if (A.style[h] != g) return a(), "pfx" == t ? h : !0
        }
        return a(), !1
    }

    function g(e, t, n, o, r) {
        var s = e.charAt(0).toUpperCase() + e.slice(1), a = (e + " " + E.join(s + " ") + s).split(" ");
        return i(t, "string") || i(t, "undefined") ? h(a, t, o, r) : (a = (e + " " + P.join(s + " ") + s).split(" "), c(a, t, n))
    }

    function v(e, t, i) {
        return g(e, n, n, t, i)
    }

    var y = [], b = [], x = {
        _version: "3.3.1",
        _config: {classPrefix: "", enableClasses: !0, enableJSClass: !0, usePrefixes: !0},
        _q: [],
        on: function (e, t) {
            var n = this;
            setTimeout(function () {
                t(n[e])
            }, 0)
        },
        addTest: function (e, t, n) {
            b.push({name: e, fn: t, options: n})
        },
        addAsyncTest: function (e) {
            b.push({name: null, fn: e})
        }
    }, Modernizr = function () {
    };
    Modernizr.prototype = x, Modernizr = new Modernizr, Modernizr.addTest("cookies", function () {
        try {
            t.cookie = "cookietest=1";
            var e = -1 != t.cookie.indexOf("cookietest=");
            return t.cookie = "cookietest=1; expires=Thu, 01-Jan-1970 00:00:01 GMT", e
        } catch (n) {
            return !1
        }
    }), Modernizr.addTest("json", "JSON" in e && "parse" in JSON && "stringify" in JSON), Modernizr.addTest("queryselector", "querySelector" in t && "querySelectorAll" in t), Modernizr.addTest("svg", !!t.createElementNS && !!t.createElementNS("http://www.w3.org/2000/svg", "svg").createSVGRect), Modernizr.addTest("atobbtoa", "atob" in e && "btoa" in e, {aliases: ["atob-btoa"]});
    var w = t.documentElement;
    Modernizr.addTest("classlist", "classList" in w);
    var S = "svg" === w.nodeName.toLowerCase(),
        T = x._config.usePrefixes ? " -webkit- -moz- -o- -ms- ".split(" ") : ["", ""];
    x._prefixes = T, Modernizr.addTest("cssgradients", function () {
        for (var e, t = "background-image:", n = "gradient(linear,left top,right bottom,from(#9f9),to(white));", i = "", o = 0, r = T.length - 1; r > o; o++) e = 0 === o ? "to " : "", i += t + T[o] + "linear-gradient(" + e + "left top, #9f9, white);";
        Modernizr._config.usePrefixes && (i += t + "-webkit-" + n);
        var a = s("a"), l = a.style;
        return l.cssText = i, ("" + l.backgroundImage).indexOf("gradient") > -1
    });
    var C = s("input"),
        k = "search tel url email datetime date month week time datetime-local number range color".split(" "), z = {};
    Modernizr.inputtypes = function (e) {
        for (var i, o, r, s = e.length, a = "1)", l = 0; s > l; l++) C.setAttribute("type", i = e[l]), r = "text" !== C.type && "style" in C, r && (C.value = a, C.style.cssText = "position:absolute;visibility:hidden;", /^range$/.test(i) && C.style.WebkitAppearance !== n ? (w.appendChild(C), o = t.defaultView, r = o.getComputedStyle && "textfield" !== o.getComputedStyle(C, null).WebkitAppearance && 0 !== C.offsetHeight, w.removeChild(C)) : /^(search|tel)$/.test(i) || (r = /^(url|email)$/.test(i) ? C.checkValidity && C.checkValidity() === !1 : C.value != a)), z[e[l]] = !!r;
        return z
    }(k);
    var _ = x.testStyles = l;
    Modernizr.addTest("touchevents", function () {
        var n;
        if ("ontouchstart" in e || e.DocumentTouch && t instanceof DocumentTouch) n = !0; else {
            var i = ["@media (", T.join("touch-enabled),("), "heartz", ")", "{#modernizr{top:9px;position:absolute}}"].join("");
            _(i, function (e) {
                n = 9 === e.offsetTop
            })
        }
        return n
    }), _("#modernizr{display: table; direction: ltr}#modernizr div{display: table-cell; padding: 10px}", function (e) {
        var t, n = e.childNodes;
        t = n[0].offsetLeft < n[1].offsetLeft, Modernizr.addTest("displaytable", t, {aliases: ["display-table"]})
    }, 2), _("#modernizr div {width:1px} #modernizr div:nth-child(2n) {width:2px;}", function (e) {
        for (var t = e.getElementsByTagName("div"), n = !0, i = 0; 5 > i; i++) n = n && t[i].offsetWidth === i % 2 + 1;
        Modernizr.addTest("nthchild", n)
    }, 5);
    var N = "Moz O ms Webkit", E = x._config.usePrefixes ? N.split(" ") : [];
    x._cssomPrefixes = E;
    var P = x._config.usePrefixes ? N.toLowerCase().split(" ") : [];
    x._domPrefixes = P;
    var j = {elem: s("modernizr")};
    Modernizr._q.push(function () {
        delete j.elem
    });
    var A = {style: j.elem.style};
    Modernizr._q.unshift(function () {
        delete A.style
    }), x.testAllProps = g, x.testAllProps = v, Modernizr.addTest("backgroundsize", v("backgroundSize", "100%", !0)), Modernizr.addTest("bgsizecover", v("backgroundSize", "cover")), Modernizr.addTest("boxshadow", v("boxShadow", "1px 1px", !0)), Modernizr.addTest("boxsizing", v("boxSizing", "border-box", !0) && (t.documentMode === n || t.documentMode > 7)), o(), r(y), delete x.addTest, delete x.addAsyncTest;
    for (var O = 0; O < Modernizr._q.length; O++) Modernizr._q[O]();
    e.Modernizr = Modernizr
}(window, document);