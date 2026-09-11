(ns culture.facts
  "Regional-culture catalog for Osaka (大阪市) -- local dishes, festivals
  and heritage sites, piggybacked onto this municipality compliance repo
  per ADR-2607171400 (cloud-itonami-municipality-culture-catalog, in
  com-junkawasaki/root), sibling namespace to `ordinance.facts`
  (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"osaka"
   [{:culture/id "osaka.dish.takoyaki"
     :culture/name "Takoyaki"
     :culture/name-local "たこ焼き"
     :culture/municipality "osaka"
     :culture/country "JPN"
     :culture/kind :dish
     :culture/summary "Ball-shaped wheat-flour snack filled with octopus, cooked in a special molded pan; a street food invented in Osaka in 1935."
     :culture/url "https://en.wikipedia.org/wiki/Takoyaki"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "osaka.dish.okonomiyaki"
     :culture/name "Okonomiyaki"
     :culture/name-local "お好み焼き"
     :culture/municipality "osaka"
     :culture/country "JPN"
     :culture/kind :dish
     :culture/summary "Savory teppan pancake of wheat-flour batter with cabbage and other ingredients; the Kansai/Osaka style is the predominant version found throughout most of Japan."
     :culture/url "https://en.wikipedia.org/wiki/Okonomiyaki"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "osaka.dish.kushikatsu"
     :culture/name "Kushikatsu"
     :culture/name-local "串カツ"
     :culture/municipality "osaka"
     :culture/country "JPN"
     :culture/kind :dish
     :culture/summary "Deep-fried skewered meat and vegetables, originating in Osaka's Shinsekai district around 1929 as affordable fast food."
     :culture/url "https://en.wikipedia.org/wiki/Kushikatsu"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "osaka.dish.battera"
     :culture/name "Battera"
     :culture/name-local "バッテラ"
     :culture/municipality "osaka"
     :culture/country "JPN"
     :culture/kind :dish
     :culture/summary "Pressed sushi of vinegar-cured mackerel, created at an Osaka sushi shop around 1893; the name derives from Portuguese 'bateira' (small boat)."
     :culture/url "https://ja.wikipedia.org/wiki/%E3%83%90%E3%83%83%E3%83%86%E3%83%A9"
     :culture/url-provenance :wikipedia-ja
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "osaka.festival.tenjin-matsuri"
     :culture/name "Tenjin Matsuri"
     :culture/name-local "天神祭"
     :culture/municipality "osaka"
     :culture/country "JPN"
     :culture/kind :festival
     :culture/summary "Annual festival of Osaka Tenmangū Shrine held on 24-25 July, featuring street processions, a boat procession and fireworks."
     :culture/url "https://en.wikipedia.org/wiki/Tenjin_Matsuri"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "osaka.heritage.osaka-castle"
     :culture/name "Osaka Castle"
     :culture/name-local "大阪城"
     :culture/municipality "osaka"
     :culture/country "JPN"
     :culture/kind :heritage
     :culture/summary "Castle in Chūō-ku originally constructed in 1583; one of Japan's most famous landmarks."
     :culture/url "https://en.wikipedia.org/wiki/Osaka_Castle"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "osaka.heritage.sumiyoshi-taisha"
     :culture/name "Sumiyoshi-taisha"
     :culture/name-local "住吉大社"
     :culture/municipality "osaka"
     :culture/country "JPN"
     :culture/kind :heritage
     :culture/summary "Head shrine of all Sumiyoshi shrines, in Sumiyoshi-ku; its honden is the oldest example of the sumiyoshi-zukuri architectural style and a National Treasure."
     :culture/url "https://en.wikipedia.org/wiki/Sumiyoshi-taisha"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "osaka.heritage.bunraku"
     :culture/name "Bunraku"
     :culture/name-local "文楽"
     :culture/municipality "osaka"
     :culture/country "JPN"
     :culture/kind :heritage
     :culture/summary "Traditional Japanese puppet theatre founded in Osaka in the early 17th century; Osaka hosts the National Bunraku Theatre, and the art is recognized by UNESCO as Intangible Cultural Heritage of Humanity."
     :culture/url "https://en.wikipedia.org/wiki/Bunraku"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "osaka.heritage.shitennoji"
     :culture/name "Shitennō-ji"
     :culture/name-local "四天王寺"
     :culture/municipality "osaka"
     :culture/country "JPN"
     :culture/kind :heritage
     :culture/summary "Buddhist temple in Osaka established in 593 CE, sometimes regarded as the oldest officially administered temple in Japan; the present structures are later reconstructions."
     :culture/url "https://en.wikipedia.org/wiki/Shitenn%C5%8D-ji"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-municipality-jpn-osaka culture catalog "
                 "(ADR-2607171400): " (count (get catalog "osaka"))
                 " Osaka entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
