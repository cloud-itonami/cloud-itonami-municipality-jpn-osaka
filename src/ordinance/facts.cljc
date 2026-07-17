(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Osaka (大阪市) -- a Wave 1b
  addition per ADR-2607171400 addendum 2, joining the
  cloud-itonami-municipality-* compliance-fact family of ADR-2607141700
  (cloud-itonami-compliance-fact-federation; see
  cloud-itonami-municipality-jpn-tokyo for the first Japanese sibling).

  Every entry cites an OFFICIAL city.osaka.lg.jp URL -- never fabricated.
  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/number.

  Both entries below were verified on 2026-07-17 against official
  city.osaka.lg.jp sources. The street-smoking ordinance's full text was
  read on its official page (the cited URL); its 附則 states it came into
  force on 平成19年4月1日 (2007-04-01) and records the latest amendment
  (条例第58号, promulgated 2024-03-29, effective 2025-01-27), and its
  条例番号 (平成19年大阪市条例第54号) is printed on the city's official
  designated-no-smoking-zones page
  (https://www.city.osaka.lg.jp/kankyo/page/0000503379.html, also read
  2026-07-17). :ordinance/enacted-date is intentionally omitted for that
  entry because the official page prints the entry-into-force (施行) date,
  not a separate promulgation date. The bicycle-parking provision
  ordinance was verified by downloading the official PDF and reading its
  text directly via the Read tool: the header prints
  制定 平成22年2月26日 条例第4号 / 最近改正 平成28年3月1日 条例第30号.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"osaka"
   [{:ordinance/id "osaka.rojo-kitsuen-boshi-jorei-2007"
     :ordinance/title "大阪市路上喫煙の防止に関する条例 (Osaka City Ordinance on the Prevention of Street Smoking)"
     :ordinance/municipality "osaka"
     :ordinance/country "JPN"
     :ordinance/kind :ordinance
     :ordinance/number "平成19年大阪市条例第54号"
     :ordinance/url "https://www.city.osaka.lg.jp/kankyo/page/0000009868.html"
     :ordinance/url-provenance :official-city-osaka-lg-jp
     :ordinance/last-revised-date "2024-03-29"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:public-health :public-space}}
    {:ordinance/id "osaka.jitensha-chushajo-fuchi-jorei-2010"
     :ordinance/title "大阪市自転車駐車場の附置等に関する条例 (Osaka City Ordinance on the Mandatory Provision of Bicycle Parking Facilities)"
     :ordinance/municipality "osaka"
     :ordinance/country "JPN"
     :ordinance/kind :ordinance
     :ordinance/number "平成22年条例第4号（制定 平成22年2月26日）"
     :ordinance/url "https://www.city.osaka.lg.jp/kensetsu/cmsfiles/contents/0000074/74392/shin_160301jourei.pdf"
     :ordinance/url-provenance :official-city-osaka-lg-jp
     :ordinance/enacted-date "2010-02-26"
     :ordinance/last-revised-date "2016-03-01"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:transport :urban-planning}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-jpn-osaka Wave 1b (ADR-2607171400 "
                 "addendum 2 / family ADR-2607141700): "
                 (count (get catalog "osaka")) " Osaka entries seeded with "
                 "official city.osaka.lg.jp citations. Extend "
                 "`ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
